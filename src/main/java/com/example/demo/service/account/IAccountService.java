package com.example.demo.service.account;

import com.example.demo.model.entity.Account;
import com.example.demo.model.entity.Category;
import com.example.demo.service.GeneralService;

public interface IAccountService extends GeneralService<Category> {
    Account findByAccount(String account);
}
