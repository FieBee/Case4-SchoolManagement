package com.example.demo.repository;

import com.example.demo.model.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface TeacherRepo  extends PagingAndSortingRepository<Teacher, Long> {

    Teacher findTeacherById(Long id);
    Optional<Teacher> findByLastName(String name);
}
