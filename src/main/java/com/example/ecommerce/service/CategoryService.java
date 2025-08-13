package com.example.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.model.Category;
import com.example.ecommerce.repository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
    private CategoryRepository categoryRepository;

	//create
    public Category create(Category category) {
        return categoryRepository.save(category);
    }

    //get by id
    public Category get(Long id) {
        //findById return Optional<Category>
    	//safe way to indicate return data type can either category or null
    	return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }

    public List<Category> getAll() {
        return categoryRepository.findAll();
    }
}
