package com.markcus.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.markcus.spring.modal.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {
	
	
	
}
