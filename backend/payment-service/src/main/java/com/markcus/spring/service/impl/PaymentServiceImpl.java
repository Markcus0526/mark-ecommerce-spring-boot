package com.markcus.spring.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.markcus.spring.constant.AppConstant;
import com.markcus.spring.dto.OrderDto;
import com.markcus.spring.dto.PaymentDto;
import com.markcus.spring.exception.wrapper.PaymentNotFoundException;
import com.markcus.spring.helper.PaymentMappingHelper;
import com.markcus.spring.repository.PaymentRepository;
import com.markcus.spring.service.PaymentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
	
	private final PaymentRepository paymentRepository;
	private final RestTemplate restTemplate;
	
	@Override
	public List<PaymentDto> findAll() {
		log.info("*** PaymentDto List, service; fetch all payments *");
		return this.paymentRepository.findAll()
				.stream()
					.map(PaymentMappingHelper::map)
					.map(p -> {
						p.setOrderDto(this.restTemplate.getForObject(AppConstant.DiscoveredDomainsApi
								.ORDER_SERVICE_API_URL + "/" + p.getOrderDto().getOrderId(), OrderDto.class));
						return p;
					})
					.distinct()
					.collect(Collectors.toUnmodifiableList());
	}
	
	@Override
	public PaymentDto findById(final Integer paymentId) {
		log.info("*** PaymentDto, service; fetch payment by id *");
		return this.paymentRepository.findById(paymentId)
				.map(PaymentMappingHelper::map)
				.map(p -> {
					p.setOrderDto(this.restTemplate.getForObject(AppConstant.DiscoveredDomainsApi
							.ORDER_SERVICE_API_URL + "/" + p.getOrderDto().getOrderId(), OrderDto.class));
					return p;
				})
				.orElseThrow(() -> new PaymentNotFoundException(String.format("Payment with id: %d not found", paymentId)));
	}
	
	@Override
	public PaymentDto save(final PaymentDto paymentDto) {
		log.info("*** PaymentDto, service; save payment *");
		return PaymentMappingHelper.map(this.paymentRepository
				.save(PaymentMappingHelper.map(paymentDto)));
	}
	
	@Override
	public PaymentDto update(final PaymentDto paymentDto) {
		log.info("*** PaymentDto, service; update payment *");
		return PaymentMappingHelper.map(this.paymentRepository
				.save(PaymentMappingHelper.map(paymentDto)));
	}
	
	@Override
	public void deleteById(final Integer paymentId) {
		log.info("*** Void, service; delete payment by id *");
		this.paymentRepository.deleteById(paymentId);
	}
	
	
	
}









