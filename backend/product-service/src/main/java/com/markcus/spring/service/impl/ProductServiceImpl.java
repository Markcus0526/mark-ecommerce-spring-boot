package com.markcus.spring.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import com.markcus.spring.dto.ProductDto;
import com.markcus.spring.exception.wrapper.ProductNotFoundException;
import com.markcus.spring.helper.ProductMappingHelper;
import com.markcus.spring.repository.ProductRepository;
import com.markcus.spring.service.ProductService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
	
	private final ProductRepository productRepository;
	
	@Override
	public List<ProductDto> findAll() {
		log.info("*** ProductDto List, service; fetch all products *");
		return this.productRepository.findAll()
				.stream()
					.map(ProductMappingHelper::map)
					.distinct()
					.collect(Collectors.toUnmodifiableList());
	}
	
	@Override
	public ProductDto findById(final Integer productId) {
		log.info("*** ProductDto, service; fetch product by id *");
		return this.productRepository.findById(productId)
				.map(ProductMappingHelper::map)
				.orElseThrow(() -> new ProductNotFoundException(String.format("Product with id: %d not found", productId)));
	}
	
	@Override
	public ProductDto save(final ProductDto productDto) {
		log.info("*** ProductDto, service; save product *");
		return ProductMappingHelper.map(this.productRepository
				.save(ProductMappingHelper.map(productDto)));
	}
	
	@Override
	public ProductDto update(final ProductDto productDto) {
		log.info("*** ProductDto, service; update product *");
		return ProductMappingHelper.map(this.productRepository
				.save(ProductMappingHelper.map(productDto)));
	}
	
	@Override
	public ProductDto update(final Integer productId, final ProductDto productDto) {
		log.info("*** ProductDto, service; update product with productId *");
		return ProductMappingHelper.map(this.productRepository
				.save(ProductMappingHelper.map(this.findById(productId))));
	}
	
	@Override
	public void deleteById(final Integer productId) {
		log.info("*** Void, service; delete product by id *");
		this.productRepository.delete(ProductMappingHelper
				.map(this.findById(productId)));
	}
	
	
	
}









