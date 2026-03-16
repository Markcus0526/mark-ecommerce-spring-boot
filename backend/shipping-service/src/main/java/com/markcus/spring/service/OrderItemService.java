package com.markcus.spring.service;

import java.util.List;

import com.markcus.spring.modal.id.OrderItemId;
import com.markcus.spring.dto.OrderItemDto;

public interface OrderItemService {
	
	List<OrderItemDto> findAll();
	OrderItemDto findById(final OrderItemId orderItemId);
	OrderItemDto save(final OrderItemDto orderItemDto);
	OrderItemDto update(final OrderItemDto orderItemDto);
	void deleteById(final OrderItemId orderItemId);
	
}
