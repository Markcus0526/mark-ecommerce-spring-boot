package com.markcus.spring.helper;

import com.markcus.spring.modal.Credential;
import com.markcus.spring.modal.VerificationToken;
import com.markcus.spring.dto.CredentialDto;
import com.markcus.spring.dto.VerificationTokenDto;

public interface VerificationTokenMappingHelper {
	
	public static VerificationTokenDto map(final VerificationToken verificationToken) {
		return VerificationTokenDto.builder()
				.verificationTokenId(verificationToken.getVerificationTokenId())
				.token(verificationToken.getToken())
				.expireDate(verificationToken.getExpireDate())
				.credentialDto(
						CredentialDto.builder()
							.credentialId(verificationToken.getCredential().getCredentialId())
							.username(verificationToken.getCredential().getUsername())
							.password(verificationToken.getCredential().getPassword())
							.roleBasedAuthority(verificationToken.getCredential().getRoleBasedAuthority())
							.isEnabled(verificationToken.getCredential().getIsEnabled())
							.isAccountNonExpired(verificationToken.getCredential().getIsAccountNonExpired())
							.isAccountNonLocked(verificationToken.getCredential().getIsAccountNonLocked())
							.isCredentialsNonExpired(verificationToken.getCredential().getIsCredentialsNonExpired())
							.build())
				.build();
	}
	
	public static VerificationToken map(final VerificationTokenDto verificationTokenDto) {
		return VerificationToken.builder()
				.verificationTokenId(verificationTokenDto.getVerificationTokenId())
				.token(verificationTokenDto.getToken())
				.expireDate(verificationTokenDto.getExpireDate())
				.credential(
						Credential.builder()
							.credentialId(verificationTokenDto.getCredentialDto().getCredentialId())
							.username(verificationTokenDto.getCredentialDto().getUsername())
							.password(verificationTokenDto.getCredentialDto().getPassword())
							.roleBasedAuthority(verificationTokenDto.getCredentialDto().getRoleBasedAuthority())
							.isEnabled(verificationTokenDto.getCredentialDto().getIsEnabled())
							.isAccountNonExpired(verificationTokenDto.getCredentialDto().getIsAccountNonExpired())
							.isAccountNonLocked(verificationTokenDto.getCredentialDto().getIsAccountNonLocked())
							.isCredentialsNonExpired(verificationTokenDto.getCredentialDto().getIsCredentialsNonExpired())
							.build())
				.build();
	}
	
	
	
}






