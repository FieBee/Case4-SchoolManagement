package com.example.demo.service.Iclass;


import com.example.demo.model.entity.Payment;

import com.example.demo.model.entity.Class;
import com.example.demo.repository.ClassRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ClassService implements IClassService{
    @Autowired
    private ClassRepo classRepo;

    @Override
    public Iterable<Class> findAll() {
        return classRepo.findAll();
    }

    @Override
    public Optional<Class> findById(Long id) {
        return classRepo.findById(id);
    }

    @Override
    public Class save(Class aClass) {
        return classRepo.save(aClass);
    }

    @Override
    public void remove(Long id) {
        classRepo.deleteById(id);
    }
    @Override
    public Iterable<Class> findALLByPayment(Payment payment) {
        return classRepo.findAllByPayment(payment);
    }
}
