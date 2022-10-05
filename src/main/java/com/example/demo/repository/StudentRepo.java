package com.example.demo.repository;

import com.example.demo.model.entity.Student;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepo extends PagingAndSortingRepository<Student, Long> {
    Student findStudentById(Long id);
    Optional<Student> findByLastName(String name);

    Student findByAccount(String account);

}
