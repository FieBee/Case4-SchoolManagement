package com.example.demo.service.category;

import com.example.demo.model.entity.Account;
import com.example.demo.model.entity.Category;
import com.example.demo.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService implements ICategoryService{

    @Autowired
    CategoryRepo categoryRepo;

    @Override
    public Iterable findAll() {
        return categoryRepo.findAll();
    }

    @Override
    public Optional findById(Long id) {
        return categoryRepo.findById(id);
    }

    @Override
    public Category save(Category category) {
        return categoryRepo.save(category);
    }

    @Override
    public void remove(Long id) {
        categoryRepo.deleteById(id);
    }
}
