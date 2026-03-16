package com.markcus.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.markcus.spring.modal.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	
	
}
