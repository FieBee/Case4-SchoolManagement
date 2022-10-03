package com.example.demo.service.Iclass;

import com.example.demo.model.entity.Class;
import com.example.demo.model.entity.Payment;
import com.example.demo.service.GeneralService;

public interface IClassService extends GeneralService<Class> {
    Iterable<Class>findALLByPayment(Payment payment);
}
