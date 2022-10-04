package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepo extends CrudRepository<AppUser, Long> {
    AppUser findByName(String name);
}
