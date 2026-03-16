package com.markcus.spring.helper;

import com.markcus.spring.modal.Payment;
import com.markcus.spring.dto.OrderDto;
import com.markcus.spring.dto.PaymentDto;

public interface PaymentMappingHelper {
	
	public static PaymentDto map(final Payment payment) {
		return PaymentDto.builder()
				.paymentId(payment.getPaymentId())
				.isPayed(payment.getIsPayed())
				.paymentStatus(payment.getPaymentStatus())
				.orderDto(
						OrderDto.builder()
							.orderId(payment.getOrderId())
							.build())
				.build();
	}
	
	public static Payment map(final PaymentDto paymentDto) {
		return Payment.builder()
				.paymentId(paymentDto.getPaymentId())
				.orderId(paymentDto.getOrderDto().getOrderId())
				.isPayed(paymentDto.getIsPayed())
				.paymentStatus(paymentDto.getPaymentStatus())
				.build();
	}
	
	
	
}










