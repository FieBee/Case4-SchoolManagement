package com.example.demo.repository;

import com.example.demo.model.entity.Class;
import com.example.demo.model.entity.Payment;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepo extends PagingAndSortingRepository<Class,Long> {
    Iterable<Class> findAllByPayment(Payment payment);
}
