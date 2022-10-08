package com.example.demo.controller;



import com.example.demo.model.entity.Student;
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
@CrossOrigin("*")
public class StudentController {

    @Autowired
    IStudentService studentService;

//    @GetMapping
//    public ModelAndView getStudent(){
//        return new ModelAndView("student");
//    }

    @GetMapping
    public ResponseEntity<Iterable<Student>> findAllStudent(@RequestParam Optional<String> search, Pageable pageable) {
        Page<Student> student = studentService.findAll(pageable);
        if (student.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        if (search.isPresent()) {
            return new ResponseEntity<>(studentService.findAllByFirstNameContaining(search.get(), pageable), HttpStatus.OK);
        }
        return new ResponseEntity<>(student, HttpStatus.OK);
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
    public ResponseEntity<Student> save(@RequestBody Student student){
        return new ResponseEntity<>(studentService.save(student), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id,@RequestBody  Student student){
        Optional<Student> students = studentService.findById(id);
        if (!students.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        student.setId(students.get().getId());
        return new ResponseEntity<>(studentService.save(student),HttpStatus.OK);
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
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public Map<String, String> handleValidationExceptions(
//        MethodArgumentNotValidException ex) {
//    Map<String, String> errors = new HashMap<>();
//    ex.getBindingResult().getAllErrors().forEach((error) -> {
//        String fieldName = ((FieldError) error).getField();
//        String errorMessage = error.getDefaultMessage();
//        errors.put(fieldName, errorMessage);
//    });
//    return errors;
//    }
}
