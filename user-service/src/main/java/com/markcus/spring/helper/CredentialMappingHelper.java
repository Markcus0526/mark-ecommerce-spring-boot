package com.markcus.spring.helper;

import com.markcus.spring.modal.Credential;
import com.markcus.spring.modal.User;
import com.markcus.spring.dto.CredentialDto;
import com.markcus.spring.dto.UserDto;

public interface CredentialMappingHelper {
	
	public static CredentialDto map(final Credential credential) {
		return CredentialDto.builder()
				.credentialId(credential.getCredentialId())
				.username(credential.getUsername())
				.password(credential.getPassword())
				.roleBasedAuthority(credential.getRoleBasedAuthority())
				.isEnabled(credential.getIsEnabled())
				.isAccountNonExpired(credential.getIsAccountNonExpired())
				.isAccountNonLocked(credential.getIsAccountNonLocked())
				.isCredentialsNonExpired(credential.getIsCredentialsNonExpired())
				.userDto(
						UserDto.builder()
								.userId(credential.getUser().getUserId())
								.firstName(credential.getUser().getFirstName())
								.lastName(credential.getUser().getLastName())
								.imageUrl(credential.getUser().getProfilePictureUrl())
								.email(credential.getUser().getEmail())
								.phone(credential.getUser().getContactNumber())
								.build())
				.build();
	}
	
	public static Credential map(final CredentialDto credentialDto) {
		return Credential.builder()
				.credentialId(credentialDto.getCredentialId())
				.username(credentialDto.getUsername())
				.password(credentialDto.getPassword())
				.roleBasedAuthority(credentialDto.getRoleBasedAuthority())
				.isEnabled(credentialDto.getIsEnabled())
				.isAccountNonExpired(credentialDto.getIsAccountNonExpired())
				.isAccountNonLocked(credentialDto.getIsAccountNonLocked())
				.isCredentialsNonExpired(credentialDto.getIsCredentialsNonExpired())
				.user(
						User.builder()
								.userId(credentialDto.getUserDto().getUserId())
								.firstName(credentialDto.getUserDto().getFirstName())
								.lastName(credentialDto.getUserDto().getLastName())
								.profilePictureUrl(credentialDto.getUserDto().getImageUrl())
								.email(credentialDto.getUserDto().getEmail())
								.contactNumber(credentialDto.getUserDto().getPhone())
								.build())
				.build();
	}
	
	
	
}






