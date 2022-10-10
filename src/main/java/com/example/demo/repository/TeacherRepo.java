package com.example.demo.repository;

import com.example.demo.model.entity.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeacherRepo  extends PagingAndSortingRepository<Teacher, Long> {
    Teacher findTeacherById(Long id);

    Optional<Teacher> findByLastName(String name);

    Teacher findByAccount(String account);

    Page<Teacher> findAllByFirstNameContaining(String firstName, Pageable pageable);
}
