package com.markcus.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.markcus.spring.modal.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
	
	
	
}
