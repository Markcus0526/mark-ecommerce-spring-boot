package com.markcus.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.markcus.spring.modal.VerificationToken;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Integer> {
	
	
	
}
