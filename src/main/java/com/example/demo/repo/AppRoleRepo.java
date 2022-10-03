package com.example.demo.repo;

import com.example.demo.model.dto.AppRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppRoleRepo extends CrudRepository<AppRole, Long> {
}
