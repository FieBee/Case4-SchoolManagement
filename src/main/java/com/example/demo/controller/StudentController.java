package com.example.demo.controller;



import com.example.demo.model.entity.Account;
import com.example.demo.model.entity.Course;
import com.example.demo.model.entity.Payment;
import com.example.demo.model.entity.Student;
import com.example.demo.service.account.IAccountService;
import com.example.demo.service.course.ICourseService;
import com.example.demo.service.payment.PaymentService;
import com.example.demo.service.student.IStudentService;
import com.example.demo.service.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    IStudentService studentService;


    @Autowired
    IAccountService accountService;

    @Autowired
    ICourseService courseService;

    @Autowired
    PaymentService paymentService;
//    @GetMapping
//    public ModelAndView getStudent(){
//        return new ModelAndView("student");
//    }

    @GetMapping
    public ResponseEntity<Iterable<Student>> findAllCustomer(@RequestParam Optional<String> search, Pageable pageable) {
        Page<Student> customers = studentService.findAll(pageable);
        if (customers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        if (search.isPresent()) {
            return new ResponseEntity<>(studentService.findAllByFirstNameContaining(search.get(), pageable), HttpStatus.OK);
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

//    @GetMapping
//    public ResponseEntity<Iterable<Student>> findAllCustomer(@RequestParam Optional<String> search, Pageable pageable) {
//        Page<Student> customers = studentService.findAll(pageable);
//        if (customers.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        if (search.isPresent()) {
//            return new ResponseEntity<>(studentService.findAllByLastNameContaining(search.get(), pageable), HttpStatus.OK);
//        }
//        return new ResponseEntity<>(customers, HttpStatus.OK);
//    }

//    @GetMapping("/list")
//    public ModelAndView showList(){
//        ModelAndView modelAndView = new ModelAndView("/customer/list");
//        modelAndView.addObject("customers",customerService.findAll());
//        return modelAndView;
//    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> findById(@PathVariable Long id){
        Optional<Student> students =studentService.findById(id);
        if (!students.isPresent()){
            return new  ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(students.get(),HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Student> save(@Valid @RequestBody Student customer){
        return new ResponseEntity<>(studentService.save(customer), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@Valid @PathVariable Long id,@RequestBody Student customer){
        Optional<Student> students = studentService.findById(id);
        if (!students.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        customer.setId(students.get().getId());
        return new ResponseEntity<>(studentService.save(customer),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable Long id){
        Optional<Student> students = studentService.findById(id);
        if (!students.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        studentService.remove(id);
        return new ResponseEntity<>(students.get(),HttpStatus.OK);
    }
//    sử dụng @ExceptionHandler annotation để bắt MethodArgumentNotValidException ném ra từ Spring Boot khi có
//    lỗi validate để xử lý và trả về kết quả lỗi cho client.
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
        MethodArgumentNotValidException ex) {
    Map<String, String> errors = new HashMap<>();
    ex.getBindingResult().getAllErrors().forEach((error) -> {
        String fieldName = ((FieldError) error).getField();
        String errorMessage = error.getDefaultMessage();
        errors.put(fieldName, errorMessage);
    });
    return errors;
    }

    @GetMapping("/getStudent/{account}")
    public ResponseEntity<Student> findByAccount(@PathVariable String account) {
        Optional<Student> student = studentService.findStudentByAccount_Account(account);
        if (!student.isPresent()){
            return new  ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(student.get(),HttpStatus.OK);
    }

    @PostMapping("/addCourse/{id}/{courseId}")
    public ResponseEntity<Student> addCourse(@PathVariable Long id,@PathVariable Long courseId){

        Optional<Course> course = courseService.findById(courseId);

        Optional<Student> students = studentService.findById(id);
        Student student = students.get();
        List<Course> courses = students.get().getCourses();
        courses.add(course.get());
        students.get().setCourses(courses);

        if (!students.isPresent()){
            return new  ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(studentService.save(student),HttpStatus.OK);
    }


    @PostMapping("/addPayment/{id}/{paymentId}")
    public ResponseEntity<Student> addPayment(@PathVariable Long id,@PathVariable Long paymentId){

        Optional<Payment> payment = paymentService.findById(paymentId);

        Optional<Student> students = studentService.findById(id);
        Student student = students.get();
        List<Payment> payments = students.get().getPayment();
        payments.add(payment.get());
        students.get().setPayment(payments);

        if (!students.isPresent()){
            return new  ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(studentService.save(student),HttpStatus.OK);
    }

}
