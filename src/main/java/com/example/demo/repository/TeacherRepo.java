package com.example.demo.repository;

import com.example.demo.model.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeacherRepo  extends JpaRepository<Teacher, Long> {

    Teacher findUserById(Long id);
    Optional<Teacher> findByUsername(String username);
    Boolean existsByUsername(String username);
}
