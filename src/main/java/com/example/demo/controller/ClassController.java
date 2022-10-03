package com.example.demo.controller;



import com.example.demo.model.entity.Class;
import com.example.demo.service.Iclass.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/class")
public class ClassController {

    @Autowired
    ClassService classService;
    @GetMapping
    public ResponseEntity<Iterable<Class>> findAllClass(){
        List<Class> classes = (List<Class>)classService.findAll();
        if (classes.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(classes,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Class> findById(@PathVariable Long id){
        Optional<Class> students =classService.findById(id);
        if (!students.isPresent()){
            return new  ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(students.get(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Class> save(@RequestBody Class customer){
        return new ResponseEntity<>(classService.save(customer), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Class> updateStudent(@PathVariable Long id,@RequestBody Class aClass){
        Optional<Class> classOptional = classService.findById(id);
        if (!classOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        aClass.setId(classOptional.get().getId());
        return new ResponseEntity<>(classService.save(aClass),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Class> deleteStudent(@PathVariable Long id){
        Optional<Class> classOptional = classService.findById(id);
        if (!classOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        classService.remove(id);
        return new ResponseEntity<>(classOptional.get(),HttpStatus.OK);
    }
}
