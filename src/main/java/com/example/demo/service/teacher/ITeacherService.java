package com.example.demo.service.teacher;

import com.example.demo.model.entity.Student;
import com.example.demo.model.entity.Teacher;
import com.example.demo.service.GeneralService;

import java.util.Optional;

public interface ITeacherService  extends GeneralService<Teacher> {
    Optional<Teacher> findStudentByAccount_Account(String userName);
    Teacher findByMail(String email);
}
