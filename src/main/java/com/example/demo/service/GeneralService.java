package com.example.demo.service;

import com.example.demo.model.entity.Account;

import java.util.Optional;

public interface GeneralService<T> {
    Iterable<T> findAll();

    Optional<T> findById(Long id);

    T save(T t);

    void remove(Long id);
}
