package com.example.demo.repository;

import com.example.demo.model.entity.Student;
import com.example.demo.model.entity.Teacher;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeacherRepo  extends PagingAndSortingRepository<Teacher, Long> {
    Teacher findTeacherById(Long id);
    Optional<Teacher> findByLastName(String name);

    Teacher findByAccount(String account);
    Optional<Teacher> findTeacherByAccount_Account(String userName);

    @Query("select t from Teacher t where t.email = ?1")
    Teacher findByEmail(String email);
}
