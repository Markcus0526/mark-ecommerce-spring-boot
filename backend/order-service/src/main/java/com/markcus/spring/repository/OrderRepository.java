package com.markcus.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.markcus.spring.modal.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
	
	
	
}
