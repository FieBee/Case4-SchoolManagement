package com.example.demo.controller;

import com.example.demo.model.entity.Course;
import com.example.demo.model.entity.Student;
import com.example.demo.service.course.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    ICourseService courseService;

    @GetMapping
    public ResponseEntity<Iterable<Course>> findAllCourse(){
        List<Course> courses = (List<Course>)courseService.findAll();
        if (courses.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(courses,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> findById(@PathVariable Long id){
        Optional<Course> course =courseService.findById(id);
        if (!course.isPresent()){
            return new  ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(course.get(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Course> save(@RequestBody Course course){
        return new ResponseEntity<>(courseService.save(course), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable Long id,@RequestBody Course course){
        Optional<Course> course1 = courseService.findById(id);
        if (!course1.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        course.setId(course1.get().getId());
        return new ResponseEntity<>(courseService.save(course),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Course> deleteCourse(@PathVariable Long id){
        Optional<Course> course = courseService.findById(id);
        if (!course.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        courseService.remove(id);
        return new ResponseEntity<>(course.get(),HttpStatus.OK);
    }

}
