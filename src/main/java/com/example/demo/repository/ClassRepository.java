package com.example.demo.repository;

import com.example.demo.Payment;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends PagingAndSortingRepository<Class,Long> {
    Iterable<Class> findAllByPayment(Payment payment);
}
