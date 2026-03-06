package com.markcus.spring.business.auth.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.markcus.spring.business.auth.model.request.AuthenticationRequest;
import com.markcus.spring.business.auth.model.response.AuthenticationResponse;
import com.markcus.spring.business.auth.service.AuthenticationService;
import com.markcus.spring.exception.wrapper.IllegalAuthenticationCredentialsException;
import com.markcus.spring.jwt.service.JwtService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
	
	private static final Logger log = LoggerFactory.getLogger(AuthenticationServiceImpl.class);
	
	private final AuthenticationManager authenticationManager;
	private final UserDetailsService userDetailsService;
	private final JwtService jwtService;
	
	public AuthenticationServiceImpl(AuthenticationManager authenticationManager, 
			UserDetailsService userDetailsService, JwtService jwtService) {
		this.authenticationManager = authenticationManager;
		this.userDetailsService = userDetailsService;
		this.jwtService = jwtService;
	}
	
	@Override
	public AuthenticationResponse authenticate(final AuthenticationRequest authenticationRequest) {
		
		log.info("** AuthenticationResponse, authenticate user service*\n");
		
		try {
			this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		}
		catch (BadCredentialsException e) {
			throw new IllegalAuthenticationCredentialsException("#### Bad credentials! ####");
		}
		
		return new AuthenticationResponse(this.jwtService.generateToken(this.userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername())));
	}
	
	@Override
	public Boolean authenticate(final String jwt) {
		return null;
	}
	
	
	
}










