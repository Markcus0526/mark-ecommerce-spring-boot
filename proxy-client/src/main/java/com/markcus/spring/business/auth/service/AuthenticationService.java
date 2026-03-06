package com.markcus.spring.business.auth.service;

import com.markcus.spring.business.auth.model.request.AuthenticationRequest;
import com.markcus.spring.business.auth.model.response.AuthenticationResponse;

public interface AuthenticationService {
	
	AuthenticationResponse authenticate(final AuthenticationRequest authenticationRequest);
	Boolean authenticate(final String jwt);
	
}
