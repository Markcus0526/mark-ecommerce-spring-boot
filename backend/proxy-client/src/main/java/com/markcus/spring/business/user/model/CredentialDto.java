package com.markcus.spring.business.user.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CredentialDto {
	
	private Integer credentialId;
	private String username;
	private String password;
	private RoleBasedAuthority roleBasedAuthority;
	private Boolean isEnabled;
	private Boolean isAccountNonExpired;
	private Boolean isAccountNonLocked;
	private Boolean isCredentialsNonExpired;
	
	@JsonProperty("user")
	@JsonInclude(value = Include.NON_NULL)
	private UserDto userDto;
	
	@JsonInclude(value = Include.NON_NULL)
	private Set<VerificationTokenDto> verificationTokenDtos;
	
	public Integer getCredentialId() {
		return credentialId;
	}
	
	public void setCredentialId(Integer credentialId) {
		this.credentialId = credentialId;
	}
	
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
	
	public RoleBasedAuthority getRoleBasedAuthority() {
		return roleBasedAuthority;
	}
	
	public void setRoleBasedAuthority(RoleBasedAuthority roleBasedAuthority) {
		this.roleBasedAuthority = roleBasedAuthority;
	}
	
	public Boolean getIsEnabled() {
		return isEnabled;
	}
	
	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
	
	public Boolean getIsAccountNonExpired() {
		return isAccountNonExpired;
	}
	
	public void setIsAccountNonExpired(Boolean isAccountNonExpired) {
		this.isAccountNonExpired = isAccountNonExpired;
	}
	
	public Boolean getIsAccountNonLocked() {
		return isAccountNonLocked;
	}
	
	public void setIsAccountNonLocked(Boolean isAccountNonLocked) {
		this.isAccountNonLocked = isAccountNonLocked;
	}
	
	public Boolean getIsCredentialsNonExpired() {
		return isCredentialsNonExpired;
	}
	
	public void setIsCredentialsNonExpired(Boolean isCredentialsNonExpired) {
		this.isCredentialsNonExpired = isCredentialsNonExpired;
	}
	
	public UserDto getUserDto() {
		return userDto;
	}
	
	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}
	
	public Set<VerificationTokenDto> getVerificationTokenDtos() {
		return verificationTokenDtos;
	}
	
	public void setVerificationTokenDtos(Set<VerificationTokenDto> verificationTokenDtos) {
		this.verificationTokenDtos = verificationTokenDtos;
	}
}







