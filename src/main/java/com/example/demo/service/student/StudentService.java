package com.example.demo.service.student;

import com.example.demo.model.entity.Student;
import com.example.demo.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Student student = studentRepo.findByAccount(username);

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(student.getAppRole());

        UserDetails userDetails = new User(
                student.getAccount(),
                student.getPassword(),
                grantedAuthorities
        );
        return userDetails;

    }
}
