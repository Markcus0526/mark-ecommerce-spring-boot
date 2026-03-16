package com.markcus.spring.business.auth.model.request;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AuthenticationRequest implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@NotBlank(message = "*Username must not be empty!**")
	private String username;
	
	@NotNull(message = "*Password must not be null!**")
	private String password;
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}










