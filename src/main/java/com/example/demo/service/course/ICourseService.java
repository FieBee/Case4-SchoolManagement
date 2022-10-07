package com.example.demo.service.course;

import com.example.demo.model.entity.Course;
import com.example.demo.service.GeneralService;

import java.util.List;

public interface ICourseService extends GeneralService<Course> {
    public List<Course> showCourseByStudentId(Long id);
}
