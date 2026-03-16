package com.markcus.spring.dto;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer userId;
	
	private String firstName;

	private String lastName;

	private String imageUrl;

	private String email;

	private String phone;

	@JsonInclude(value = Include.NON_NULL)
	private Set<AddressDto> addressDtos;

	@JsonProperty("credential")
	@JsonInclude(value = Include.NON_NULL)
	private CredentialDto credentialDto;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Set<AddressDto> getAddressDtos() {
		return addressDtos;
	}

	public void setAddressDtos(Set<AddressDto> addressDtos) {
		this.addressDtos = addressDtos;
	}

	public CredentialDto getCredentialDto() {
		return credentialDto;
	}

	public void setCredentialDto(CredentialDto credentialDto) {
		this.credentialDto = credentialDto;
	}

}










