package com.example.demo.service.teacher;

import com.example.demo.model.entity.Teacher;
import com.example.demo.service.GeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ITeacherService  extends GeneralService<Teacher> {
    Page<Teacher> findAll (Pageable pageable);

    Page<Teacher> findAllByFirstNameContaining(String firstName, Pageable pageable);
}
