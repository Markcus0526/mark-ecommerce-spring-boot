package com.markcus.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.markcus.spring.modal.OrderItem;
import com.markcus.spring.modal.id.OrderItemId;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemId> {
	
	
	
}
