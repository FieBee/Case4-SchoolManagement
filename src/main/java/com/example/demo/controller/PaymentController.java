package com.example.demo.controller;

import com.example.demo.model.entity.Category;
import com.example.demo.model.entity.Payment;
import com.example.demo.service.payment.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    IPaymentService paymentService;

    @GetMapping
    public ResponseEntity<Iterable<Payment>> fideAllPayment() {
        List<Payment> payments = (List<Payment>) paymentService.findAll();
        if (payments.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(payments, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payment> findById(@PathVariable Long id) {
        Optional<Payment> payment = paymentService.findById(id);
        if (!payment.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(payment.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Payment> save(@RequestBody Payment payment){
        return new ResponseEntity<>(paymentService.save(payment), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Payment> updatePayment(@PathVariable Long id,@RequestBody Payment payment){
        Optional<Payment> payment1 = paymentService.findById(id);
        if (!payment1.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        payment.setId(payment1.get().getId());
        return new ResponseEntity<>(paymentService.save(payment),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Payment> deletePayment(@PathVariable Long id){
        Optional<Payment> payment = paymentService.findById(id);
        if (!payment.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        paymentService.remove(id);
        return new ResponseEntity<>(payment.get(),HttpStatus.OK);
    }

}
