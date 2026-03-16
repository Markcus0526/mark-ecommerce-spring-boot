package com.markcus.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.markcus.spring.modal.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
	
	
	
}
