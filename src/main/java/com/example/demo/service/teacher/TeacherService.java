package com.example.demo.service.teacher;

import com.example.demo.model.entity.Teacher;
import com.example.demo.repository.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Override
    public Page<Teacher> findAll(Pageable pageable) {
        return teacherRepo.findAll(pageable);
    }

    @Override
    public Page<Teacher> findAllByFirstNameContaining(String firstName, Pageable pageable) {
        return teacherRepo.findAllByFirstNameContaining(firstName,pageable);
    }
}
