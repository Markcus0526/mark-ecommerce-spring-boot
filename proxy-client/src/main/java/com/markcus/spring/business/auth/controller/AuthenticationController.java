package com.markcus.spring.business.auth.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.markcus.spring.business.auth.model.request.AuthenticationRequest;
import com.markcus.spring.business.auth.model.response.AuthenticationResponse;
import com.markcus.spring.business.auth.service.AuthenticationService;

@RestController
@RequestMapping("/api/authenticate")
public class AuthenticationController {
	
	private static final Logger log = LoggerFactory.getLogger(AuthenticationController.class);
	
	private final AuthenticationService authenticationService;
	
	public AuthenticationController(AuthenticationService authenticationService) {
		this.authenticationService = authenticationService;
	}
	
	@PostMapping
	public ResponseEntity<AuthenticationResponse> authenticate(
			@RequestBody 
			@NotNull(message = "")
			@Valid final AuthenticationRequest authenticationRequest) {
		log.info("**Authentication controller, proceed with the request*\n");
		return ResponseEntity.ok(this.authenticationService.authenticate(authenticationRequest));
	}
	
	@GetMapping("/jwt/{jwt}")
	public ResponseEntity<Boolean> authenticate(@PathVariable("jwt") final String jwt) {
		log.info("**Authentication controller, proceed with the request*\n");
		return ResponseEntity.ok(this.authenticationService.authenticate(jwt));
	}
	
	
	
}










