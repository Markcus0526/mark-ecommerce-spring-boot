package com.markcus.spring.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.markcus.spring.constant.AppConstant;
import com.markcus.spring.modal.id.FavouriteId;
import com.markcus.spring.dto.FavouriteDto;
import com.markcus.spring.dto.ProductDto;
import com.markcus.spring.dto.UserDto;
import com.markcus.spring.exception.wrapper.FavouriteNotFoundException;
import com.markcus.spring.helper.FavouriteMappingHelper;
import com.markcus.spring.repository.FavouriteRepository;
import com.markcus.spring.service.FavouriteService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class FavouriteServiceImpl implements FavouriteService {
	
	private final FavouriteRepository favouriteRepository;
	private final RestTemplate restTemplate;
	
	@Override
	public List<FavouriteDto> findAll() {
		log.info("*** FavouriteDto List, service; fetch all favourites *");
		return this.favouriteRepository.findAll()
				.stream()
					.map(FavouriteMappingHelper::map)
					.map(f -> {
						f.setUserDto(this.restTemplate
								.getForObject(AppConstant.DiscoveredDomainsApi
										.USER_SERVICE_API_URL + "/" + f.getUserId(), UserDto.class));
						f.setProductDto(this.restTemplate
								.getForObject(AppConstant.DiscoveredDomainsApi
										.PRODUCT_SERVICE_API_URL + "/" + f.getProductId(), ProductDto.class));
						return f;
					})
					.distinct()
					.collect(Collectors.toUnmodifiableList());
	}
	
	@Override
	public FavouriteDto findById(final FavouriteId favouriteId) {
		log.info("*** FavouriteDto, service; fetch favourite by id *");
		return this.favouriteRepository.findById(favouriteId)
				.map(FavouriteMappingHelper::map)
				.map(f -> {
					f.setUserDto(this.restTemplate
							.getForObject(AppConstant.DiscoveredDomainsApi
									.USER_SERVICE_API_URL + "/" + f.getUserId(), UserDto.class));
					f.setProductDto(this.restTemplate
							.getForObject(AppConstant.DiscoveredDomainsApi
									.PRODUCT_SERVICE_API_URL + "/" + f.getProductId(), ProductDto.class));
					return f;
				})
				.orElseThrow(() -> new FavouriteNotFoundException(
						String.format("Favourite with id: [%s] not found!", favouriteId)));
	}
	
	@Override
	public FavouriteDto save(final FavouriteDto favouriteDto) {
		return FavouriteMappingHelper.map(this.favouriteRepository
				.save(FavouriteMappingHelper.map(favouriteDto)));
	}
	
	@Override
	public FavouriteDto update(final FavouriteDto favouriteDto) {
		return FavouriteMappingHelper.map(this.favouriteRepository
				.save(FavouriteMappingHelper.map(favouriteDto)));
	}
	
	@Override
	public void deleteById(final FavouriteId favouriteId) {
		this.favouriteRepository.deleteById(favouriteId);
	}
	
	
	
}










