package com.markcus.spring.helper;

import com.markcus.spring.modal.Cart;
import com.markcus.spring.dto.CartDto;
import com.markcus.spring.dto.UserDto;

public interface CartMappingHelper {
	
	public static CartDto map(final Cart cart) {
		return CartDto.builder()
				.cartId(cart.getCartId())
				.userId(cart.getUserId())
				.userDto(
						UserDto.builder()
							.userId(cart.getUserId())
							.build())
				.build();
	}
	
	public static Cart map(final CartDto cartDto) {
		return Cart.builder()
				.cartId(cartDto.getCartId())
				.userId(cartDto.getUserId())
				.build();
	}
	
	
	
}










