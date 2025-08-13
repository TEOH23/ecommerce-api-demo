package com.example.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecommerce.model.Product;

//inherit all functions from JpaRepository (extends)
//first argument inside <> will be your entity name
//second argument inside <> will be ID data type
public interface ProductRepository extends JpaRepository<Product,Long>{
	
	List<Product> findByName(String name);
	List<Product> findByPriceLessThan(double price);
	List<Product> findByDescription(String description);
	
}
