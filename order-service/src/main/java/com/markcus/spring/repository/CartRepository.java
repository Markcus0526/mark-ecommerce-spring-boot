package com.markcus.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.markcus.spring.modal.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {
	
	
	
}
