package com.markcus.spring.service;

import java.util.List;

import com.markcus.spring.dto.PaymentDto;

public interface PaymentService {
	
	List<PaymentDto> findAll();
	PaymentDto findById(final Integer paymentId);
	PaymentDto save(final PaymentDto paymentDto);
	PaymentDto update(final PaymentDto paymentDto);
	void deleteById(final Integer paymentId);
	
}
