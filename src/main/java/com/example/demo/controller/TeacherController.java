package com.example.demo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @GetMapping()
    public ModelAndView getUser(){
        return new ModelAndView("teacher");
    }
}
