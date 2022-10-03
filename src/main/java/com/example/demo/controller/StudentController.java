package com.example.demo.controller;



import com.example.demo.model.entity.Student;
import com.example.demo.service.student.IStudentService;
import com.example.demo.service.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    IStudentService studentService;

//    @GetMapping
//    public ModelAndView getStudent(){
//        return new ModelAndView("student");
//    }

    @GetMapping
    public ResponseEntity<Iterable<Student>> findAllStudent(){
        List<Student> students = (List<Student>)studentService.findAll();
        if (students.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(students,HttpStatus.OK);
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
    public ResponseEntity<Student> save(@RequestBody Student customer){
        return new ResponseEntity<>(studentService.save(customer), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id,@RequestBody Student customer){
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






}
