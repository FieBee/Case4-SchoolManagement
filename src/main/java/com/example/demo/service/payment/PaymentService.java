package com.example.demo.service.payment;

import com.example.demo.model.entity.Account;
import com.example.demo.model.entity.Payment;

import com.example.demo.repository.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class PaymentService implements IPaymentService{
    @Autowired
    private PaymentRepo paymentRepository;

    @Override
    public Iterable<Payment> findAll() {
        return paymentRepository.findAll();
    }

    @Override
    public Optional<Payment> findById(Long id) {
        return paymentRepository.findById(id);
    }
    @Override
    public Payment save(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public void remove(Long id) {
        paymentRepository.deleteById(id);
    }
}
