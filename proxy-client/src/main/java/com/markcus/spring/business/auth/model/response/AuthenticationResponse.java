package com.markcus.spring.business.auth.model.response;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AuthenticationResponse implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String jwtToken;
	
//	public AuthenticationResponse(String jwtToken) {
//		this.jwtToken = jwtToken;
//	}
//
//	public String getJwtToken() {
//		return jwtToken;
//	}
//
//	public void setJwtToken(String jwtToken) {
//		this.jwtToken = jwtToken;
//	}
}










