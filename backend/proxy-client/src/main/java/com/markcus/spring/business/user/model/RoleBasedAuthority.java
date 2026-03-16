package com.markcus.spring.business.user.model;

public enum RoleBasedAuthority {
	
	ROLE_USER("USER"),
	ROLE_ADMIN("ADMIN");
	
	private final String role;
	
	RoleBasedAuthority(String role) {
		this.role = role;
	}
	
	public String getRole() {
		return role;
	}
}
