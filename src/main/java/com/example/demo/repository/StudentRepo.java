package com.example.demo.repository;

import com.example.demo.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
    Student findUserById(Long id);
    Optional<Student> findByUsername(String username);
    Boolean existsByUsername(String username);
}
