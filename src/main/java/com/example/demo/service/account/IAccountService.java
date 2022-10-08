package com.example.demo.service.account;

import com.example.demo.model.entity.Account;
import com.example.demo.service.GeneralService;

import java.util.Optional;

public interface IAccountService extends GeneralService<Account> {
    Account findByAccount(String account);
    Optional<Account> findAccountById(Long id);

    Account findAccountByAccount(String account);
}
