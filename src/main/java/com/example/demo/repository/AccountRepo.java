package com.example.demo.repository;

import com.example.demo.model.entity.Account;
import com.example.demo.model.entity.Student;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface AccountRepo extends PagingAndSortingRepository<Account, Long> {
    Account findAccountById(Long id);

    Account findByAccount(String account);

    Account findAccountByAccount(String account);

}
