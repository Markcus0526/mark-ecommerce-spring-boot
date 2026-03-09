package com.markcus.spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.markcus.spring.modal.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByUserCredentialUsername(final String username);
	
}
