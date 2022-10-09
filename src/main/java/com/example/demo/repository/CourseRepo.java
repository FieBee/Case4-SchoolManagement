package com.example.demo.repository;



import com.example.demo.model.entity.Course;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CourseRepo extends PagingAndSortingRepository<Course,Long> {

}
