package com.markcus.spring.jwt.util.impl;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.markcus.spring.jwt.util.JwtUtil;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;

@Component
public class JwtUtilImpl implements JwtUtil {

	private static final String SECRET_KEY = "zB4fG9hK3mN7pQ2rS5tV8wX1zA4bC6dE9fG2hJ5kM8nPrSuVwXyA";

	private SecretKey getSigningKey() {
		return Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
	}

	@Override
	public String extractUsername(final String token) {
		return this.extractClaims(token, Claims::getSubject);
	}
	
	@Override
	public Date extractExpiration(final String token) {
		return this.extractClaims(token, Claims::getExpiration);
	}
	
	@Override
	public <T> T extractClaims(final String token, Function<Claims, T> claimsResolver) {
		final Claims claims = this.extractAllClaims(token);
		return claimsResolver.apply(claims);
	}

	private Claims extractAllClaims(final String token) {
		return Jwts.parser()
				.verifyWith(getSigningKey()) // Use the Key object
				.build()
				.parseSignedClaims(token)
				.getPayload();
	}
	
	private Boolean isTokenExpired(final String token) {
		return this.extractExpiration(token).before(new Date());
	}
	
	@Override
	public String generateToken(final UserDetails userDetails) {
		final Map<String, Object> claims = new HashMap<>();
		return this.createToken(claims, userDetails.getUsername());
	}
	
	private String createToken(final Map<String, Object> claims, final String subject) {
		return Jwts.builder()
				.claims(claims)
				.subject(subject)
				.issuedAt(new Date(System.currentTimeMillis()))
				.expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
				.signWith(getSigningKey())
				.compact();
	}
	
	@Override
	public Boolean validateToken(final String token, final UserDetails userDetails) {
		final String username = this.extractUsername(token);
		return (
			username.equals(userDetails.getUsername()) && !isTokenExpired(token)
		);
	}
	
	
	
}










