package com.example.demo.controller;


import com.example.demo.model.entity.Teacher;
import com.example.demo.service.account.AccountService;
import com.example.demo.service.teacher.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/teacher")
public class TeacherController {

//    @Value("${upload.path}")
//    private String upload;

    @Autowired
    TeacherService teacherService;

    @Autowired
    AccountService accountService;

    @GetMapping
    public ResponseEntity<Iterable<Teacher>> findAllTeacher(){
        List<Teacher> teachers = (List<Teacher>)teacherService.findAll();
        if (teachers.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(teachers,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Teacher> findById(@PathVariable Long id){
        Optional<Teacher> teachers =teacherService.findById(id);
        return teachers.map(teacher -> new ResponseEntity<>(teacher, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Teacher> save(@RequestBody Teacher teacher) {
        return new ResponseEntity<>(teacherService.save(teacher), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Teacher> updateTeacher(@PathVariable Long id, @RequestBody Teacher teacher) {
        Optional<Teacher> teachers = teacherService.findById(id);
        if (!teachers.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        teacher.setId(teachers.get().getId());
        return new ResponseEntity<>(teacherService.save(teacher),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Teacher> deleteStudent(@PathVariable Long id){
        Optional<Teacher> teachers = teacherService.findById(id);
        if (!teachers.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        teacherService.remove(id);
        return new ResponseEntity<>(teachers.get(),HttpStatus.OK);
    }

    @GetMapping("/list")
    public ModelAndView getAllTeacher() {
        ModelAndView modelAndView = new ModelAndView("/ajaxTeacher");
        modelAndView.addObject("teachers", teacherService.findAll());
        return modelAndView;
    }
}
