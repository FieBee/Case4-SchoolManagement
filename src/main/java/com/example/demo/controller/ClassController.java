package com.example.demo.controller;

import com.example.demo.model.entity.Payment;
import com.example.demo.service.Iclass.IClassService;
import com.example.demo.service.payment.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class ClassController {
    @Autowired
    private IClassService classService;
    @Autowired
    private IPaymentService paymentService;
    @ModelAttribute("payment")
    public Iterable<Payment>payments(){
        return paymentService.findAll();
    }

}
