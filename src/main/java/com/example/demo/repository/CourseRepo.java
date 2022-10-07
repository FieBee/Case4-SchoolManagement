package com.example.demo.repository;

import com.example.demo.model.entity.Class;
import com.example.demo.model.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CourseRepo extends PagingAndSortingRepository<Course,Long> {
    List<Course> findAllByStudent_Id(Long id);
}
