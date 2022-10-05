package com.example.demo.service.student;


import com.example.demo.model.entity.Student;
import com.example.demo.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class StudentService implements IStudentService, UserDetailsService {

    @Autowired
    StudentRepo studentRepo;

    @Override
    public Iterable<Student> findAll() {
        return studentRepo.findAll();
    }

    @Override
    public Optional<Student> findById(Long id) {
        return studentRepo.findById(id);
    }

    @Override
    public Student save(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public void remove(Long id) {
        studentRepo.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
        Student student = studentRepo.findByAccount(account);
        return new User(student.getAccount(), student.getPassword(), student.getAppRole());
    }

    @Override
    public Student findStudentByAccount(String account){
        Student student = studentRepo.findByAccount(account);
        return student;
    }



}
