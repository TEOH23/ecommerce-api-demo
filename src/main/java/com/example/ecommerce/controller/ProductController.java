package com.example.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.model.Product;
import com.example.ecommerce.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	/*@PostMapping
    public Product addProduct(@RequestBody Product product)
    {
		return productService.createProductOnly(product);
    }*/
	
	//Test flow
	//1. create a product 
	
	@PostMapping
	public Product createProduct(
	    @Valid @RequestBody Product product,
	    @RequestParam Long categoryId,
	    @RequestParam List<Long> tagIds
	) {
	    return productService.createProduct(product, categoryId, tagIds);
	}

	
	@GetMapping
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}
}
