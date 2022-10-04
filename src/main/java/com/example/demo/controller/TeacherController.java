package com.example.demo.controller;


import com.example.demo.model.entity.Teacher;
import com.example.demo.service.teacher.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Value("${upload.path}")
    private String upload;

    @Autowired
    TeacherService teacherService;

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
        if (!teachers.isPresent()){
            return new  ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(teachers.get(),HttpStatus.OK);
    }

//    @PostMapping
//    public ResponseEntity<Teacher> save(@RequestBody Teacher teacher) {
//        return new ResponseEntity<>(teacherService.save(teacher), HttpStatus.CREATED);
//    }


    @PostMapping
    public ResponseEntity<Teacher> save(@RequestPart("file")MultipartFile file, @RequestPart("teacher")Teacher teacher) {
        String fileName = file.getOriginalFilename();
        try {
            FileCopyUtils.copy(file.getBytes(), new File(upload + fileName));
        } catch (Exception e) {
            e.printStackTrace();
        }
        teacher.setImage(file.getOriginalFilename());
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
        ModelAndView modelAndView = new ModelAndView("/test/ajaxProduct");
        modelAndView.addObject("customers", teacherService.findAll());
        return modelAndView;
    }
}
