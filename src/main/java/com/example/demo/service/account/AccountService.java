package com.example.demo.service.account;

import com.example.demo.model.entity.Account;
import com.example.demo.model.entity.Category;
import com.example.demo.repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AccountService implements IAccountService, UserDetailsService {
    @Autowired
    AccountRepo accountRepo;

    @Override
    public Iterable<Account> findAll() {
        return accountRepo.findAll();
    }

    @Override
    public Optional<Account> findById(Long id) {
        return accountRepo.findById(id);
    }

    @Override
    public Account save(Account account) {
        return accountRepo.save(account);
    }

    @Override
    public void remove(Long id) {
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepo.findByAccount(username);
        return new User(account.getAccount(),account.getPassword(),  account.getAppRole());
    }
    @Override
    public Account findByAccount(String account){
        Account account1 = accountRepo.findByAccount(account);
        return account1;
    }
}
