package com.example.demo.repository;

import com.example.demo.model.entity.Course;
import com.example.demo.model.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepo extends PagingAndSortingRepository<Student, Long> {
    Student findStudentById(Long id);
    Optional<Student> findByLastName(String name);

    Page<Student> findAllByFirstNameContaining(String firstName, Pageable pageable);

//    List<Course> findAllByCourses(Long id);

}
