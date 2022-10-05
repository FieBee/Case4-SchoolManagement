package com.example.demo.controller;



import com.example.demo.model.dto.AppRole;
import com.example.demo.model.entity.Student;
import com.example.demo.model.entity.StudentToken;
import com.example.demo.service.JwtService;
import com.example.demo.service.student.IStudentService;
import com.example.demo.service.teacher.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
@CrossOrigin("*")
public class LoginAPI {
    @Autowired
    JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    IStudentService studentService;

    @Autowired
    ITeacherService teacherService;

    @PostMapping("/login")
    public StudentToken login(@RequestBody Student appUser){
        try {
            // Tạo ra 1 đối tượng Authentication.
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(appUser.getAccount(), appUser.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);

            String token = jwtService.createToken(authentication);
            Student student = studentService.findStudentByAccount(appUser.getAccount());
            return new StudentToken(student.getId(),student.getAccount(),token,student.getAppRole());
        } catch (Exception e) {
            return null;
        }

    }

    @PostMapping("/register")
    public ResponseEntity<Student> register(@RequestBody Student appUser){
        Set<AppRole> roles = new HashSet<>();
        AppRole role = new AppRole();
        role.setId(2L);
        roles.add(role);
        appUser.setAppRole(roles);
        return new ResponseEntity<>(studentService.save(appUser), HttpStatus.OK);
    }



}
