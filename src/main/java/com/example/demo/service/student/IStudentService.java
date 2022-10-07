package com.example.demo.service.student;

import com.example.demo.model.entity.Account;
import com.example.demo.model.entity.Student;
import com.example.demo.repository.StudentRepo;
import com.example.demo.service.GeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IStudentService extends GeneralService<Student> {
    Page<Student> findAll (Pageable pageable);

    Page<Student> findAllByFirstNameContaining(String firstName, Pageable pageable);

    Optional<Student> findStudentByAccount_Account(String userName);
}
