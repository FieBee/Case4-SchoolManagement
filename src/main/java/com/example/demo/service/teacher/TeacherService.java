package com.example.demo.service.teacher;

import com.example.demo.model.entity.Teacher;
import com.example.demo.repository.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeacherService implements ITeacherService {


    @Autowired
    TeacherRepo teacherRepo;

    @Override
    public Iterable<Teacher> findAll() {
        return teacherRepo.findAll();
    }

    @Override
    public Optional<Teacher> findById(Long id) {
        return teacherRepo.findById(id);
    }

    @Override
    public Teacher save(Teacher teacher) {
        return teacherRepo.save(teacher);
    }

    @Override
    public void remove(Long id) {
        teacherRepo.deleteById(id);
    }
}
