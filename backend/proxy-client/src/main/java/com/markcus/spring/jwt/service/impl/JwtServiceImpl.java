package com.markcus.spring.jwt.service.impl;

import java.util.Date;
import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.markcus.spring.jwt.service.JwtService;
import com.markcus.spring.jwt.util.JwtUtil;

import io.jsonwebtoken.Claims;

@Service
public class JwtServiceImpl implements JwtService {
	
	private static final Logger log = LoggerFactory.getLogger(JwtServiceImpl.class);
	
	private final JwtUtil jwtUtil;
	
	public JwtServiceImpl(JwtUtil jwtUtil) {
		this.jwtUtil = jwtUtil;
	}
	
	@Override
	public String extractUsername(final String token) {
		log.info("**String, jwt service extract username from given token!*");
		return this.jwtUtil.extractUsername(token);
	}
	
	@Override
	public Date extractExpiration(final String token) {
		log.info("**Date, jwt service extract expiration from given token!*");
		return this.jwtUtil.extractExpiration(token);
	}
	
	@Override
	public <T> T extractClaims(final String token, final Function<Claims, T> claimsResolver) {
		log.info("**T, jwt service extract claims from given token and claimResolver Function!*");
		return this.jwtUtil.extractClaims(token, claimsResolver);
	}
	
	@Override
	public String generateToken(final UserDetails userDetails) {
		log.info("**String, jwt service generate token from given userDetails!*");
		return this.jwtUtil.generateToken(userDetails);
	}
	
	@Override
	public Boolean validateToken(final String token, final UserDetails userDetails) {
		log.info("**Boolean, jwt service validate token from given token and userDetails!*");
		return this.jwtUtil.validateToken(token, userDetails);
	}
	
	
	
}










