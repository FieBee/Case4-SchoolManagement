package com.example.demo.service.Iclass;

import com.example.demo.model.entity.Payment;
import com.example.demo.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ClassService implements IClassService{
    @Autowired
    private ClassRepository classRepository;

    @Override
    public Iterable<Class> findAll() {
        return classRepository.findAll();
    }

    @Override
    public Optional<Class> findById(Long id) {
        return classRepository.findById(id);
    }

    @Override
    public Class save(Class aClass) {
        return classRepository.save(aClass);
    }

    @Override
    public void remove(Long id) {
        classRepository.deleteById(id);
    }
    @Override
    public Iterable<Class> findALLByPayment(Payment payment) {
        return classRepository.findAllByPayment(payment);
    }
}
