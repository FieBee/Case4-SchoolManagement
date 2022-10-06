package com.example.demo.service.course;

import com.example.demo.model.entity.Account;
import com.example.demo.model.entity.Course;
import com.example.demo.repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseService implements ICourseService{

    @Autowired
    CourseRepo courseRepo;

    @Override
    public Iterable<Course> findAll() {
        return courseRepo.findAll();
    }

    @Override
    public Optional<Course> findById(Long id) {
        return courseRepo.findById(id);
    }

    @Override
    public Course save(Course course) {
        return courseRepo.save(course);
    }

    @Override
    public void remove(Long id) {
        courseRepo.deleteById(id);
    }
}
