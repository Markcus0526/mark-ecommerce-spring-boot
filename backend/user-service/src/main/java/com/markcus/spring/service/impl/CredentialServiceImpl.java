package com.markcus.spring.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import com.markcus.spring.dto.CredentialDto;
import com.markcus.spring.exception.wrapper.CredentialNotFoundException;
import com.markcus.spring.exception.wrapper.UserObjectNotFoundException;
import com.markcus.spring.helper.CredentialMappingHelper;
import com.markcus.spring.repository.CredentialRepository;
import com.markcus.spring.service.CredentialService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class CredentialServiceImpl implements CredentialService {
	
	private final CredentialRepository credentialRepository;
	
	@Override
	public List<CredentialDto> findAll() {
		log.info("*** CredentialDto List, service; fetch all credentials *");
		return this.credentialRepository.findAll()
				.stream()
					.map(CredentialMappingHelper::map)
					.distinct()
					.collect(Collectors.toUnmodifiableList());
	}
	
	@Override
	public CredentialDto findById(final Integer credentialId) {
		log.info("*** CredentialDto, service; fetch credential by ids *");
		return this.credentialRepository.findById(credentialId)
				.map(CredentialMappingHelper::map)
				.orElseThrow(() -> new CredentialNotFoundException(String.format("#### Credential with id: %d not found! ####", credentialId)));
	}
	
	@Override
	public CredentialDto save(final CredentialDto credentialDto) {
		log.info("*** CredentialDto, service; save credential *");
		return CredentialMappingHelper.map(this.credentialRepository.save(CredentialMappingHelper.map(credentialDto)));
	}
	
	@Override
	public CredentialDto update(final CredentialDto credentialDto) {
		log.info("*** CredentialDto, service; update credential *");
		return CredentialMappingHelper.map(this.credentialRepository.save(CredentialMappingHelper.map(credentialDto)));
	}
	
	@Override
	public CredentialDto update(final Integer credentialId, final CredentialDto credentialDto) {
		log.info("*** CredentialDto, service; update credential with credentialId *");
		return CredentialMappingHelper.map(this.credentialRepository.save(
				CredentialMappingHelper.map(this.findById(credentialId))));
	}
	
	@Override
	public void deleteById(final Integer credentialId) {
		log.info("*** Void, service; delete credential by id *");
		this.credentialRepository.deleteById(credentialId);
	}
	
	@Override
	public CredentialDto findByUsername(final String username) {
		return CredentialMappingHelper.map(this.credentialRepository.findByUsername(username)
				.orElseThrow(() -> new UserObjectNotFoundException(String.format("#### Credential with username: %s not found! ####", username))));
	}
	
	
	
}










