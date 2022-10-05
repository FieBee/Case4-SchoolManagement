package com.example.demo.service.account;

import com.example.demo.model.entity.Account;
import com.example.demo.model.entity.Category;
import com.example.demo.model.entity.Student;
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
    public Iterable<Category> findAll() {
        return null;
    }

    @Override
    public Optional<Category> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Category save(Category category) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepo.findByAccount(username);
        return new User(account.getAccount(),account.getPassword(),account.getAppRole());
    }
    @Override
    public Account findByAccount(String account){
        Account account1 = accountRepo.findByAccount(account);
        return account1;
    }
}
