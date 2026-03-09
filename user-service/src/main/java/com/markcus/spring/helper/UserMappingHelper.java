package com.markcus.spring.helper;

import com.markcus.spring.modal.Credential;
import com.markcus.spring.modal.User;
import com.markcus.spring.dto.CredentialDto;
import com.markcus.spring.dto.UserDto;

public interface UserMappingHelper {
	
	public static UserDto map(final User user) {
		return UserDto.builder()
				.userId(user.getUserId())
				.firstName(user.getFirstName())
				.lastName(user.getLastName())
				.imageUrl(user.getProfilePictureUrl())
				.email(user.getEmail())
				.phone(user.getContactNumber())
				.credentialDto(
						CredentialDto.builder()
							.credentialId(user.getUserCredential().getCredentialId())
							.username(user.getUserCredential().getUsername())
							.password(user.getUserCredential().getPassword())
							.roleBasedAuthority(user.getUserCredential().getRoleBasedAuthority())
							.isEnabled(user.getUserCredential().getIsEnabled())
							.isAccountNonExpired(user.getUserCredential().getIsAccountNonExpired())
							.isAccountNonLocked(user.getUserCredential().getIsAccountNonLocked())
							.isCredentialsNonExpired(user.getUserCredential().getIsCredentialsNonExpired())
							.build())
				.build();
	}
	
	public static User map(final UserDto userDto) {
		return User.builder()
				.userId(userDto.getUserId())
				.firstName(userDto.getFirstName())
				.lastName(userDto.getLastName())
				.profilePictureUrl(userDto.getImageUrl())
				.email(userDto.getEmail())
				.contactNumber(userDto.getPhone())
				.userCredential(
						Credential.builder()
							.credentialId(userDto.getCredentialDto().getCredentialId())
							.username(userDto.getCredentialDto().getUsername())
							.password(userDto.getCredentialDto().getPassword())
							.roleBasedAuthority(userDto.getCredentialDto().getRoleBasedAuthority())
							.isEnabled(userDto.getCredentialDto().getIsEnabled())
							.isAccountNonExpired(userDto.getCredentialDto().getIsAccountNonExpired())
							.isAccountNonLocked(userDto.getCredentialDto().getIsAccountNonLocked())
							.isCredentialsNonExpired(userDto.getCredentialDto().getIsCredentialsNonExpired())
							.build())
				.build();
	}
	
	
	
}






