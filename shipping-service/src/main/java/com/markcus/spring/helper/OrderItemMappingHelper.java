package com.markcus.spring.helper;

import com.markcus.spring.modal.OrderItem;
import com.markcus.spring.dto.OrderDto;
import com.markcus.spring.dto.OrderItemDto;
import com.markcus.spring.dto.ProductDto;

public interface OrderItemMappingHelper {
	
	public static OrderItemDto map(final OrderItem orderItem) {
		return OrderItemDto.builder()
				.productId(orderItem.getProductId())
				.orderId(orderItem.getOrderId())
				.orderedQuantity(orderItem.getOrderedQuantity())
				.productDto(
						ProductDto.builder()
							.productId(orderItem.getProductId())
							.build())
				.orderDto(
						OrderDto.builder()
							.orderId(orderItem.getOrderId())
							.build())
				.build();
	}
	
	public static OrderItem map(final OrderItemDto orderItemDto) {
		return OrderItem.builder()
				.productId(orderItemDto.getProductId())
				.orderId(orderItemDto.getOrderId())
				.orderedQuantity(orderItemDto.getOrderedQuantity())
				.build();
	}
	
	
	
}










