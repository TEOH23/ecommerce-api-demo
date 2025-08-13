package com.example.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.model.Category;
import com.example.ecommerce.service.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public Category create(@Valid @RequestBody Category category) {
        return categoryService.create(category);
    }
    
    @GetMapping("/{id}")
    public Category getCategory(@PathVariable Long id) {
        return categoryService.get(id);
    }

    @GetMapping
    public List<Category> getAll() {
        return categoryService.getAll();
    }
}
