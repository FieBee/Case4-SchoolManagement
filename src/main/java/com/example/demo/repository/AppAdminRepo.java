package com.example.demo.repository;

import com.example.demo.model.entity.Account;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AppAdminRepo extends PagingAndSortingRepository<Account, Long> {
}
