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
public class TeacherService implements ITeacherService, UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Teacher teacher = teacherRepo.findByAccount(username);
        return new User(teacher.getAccount(), teacher.getPassword(), teacher.getAppRole());
    }

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
