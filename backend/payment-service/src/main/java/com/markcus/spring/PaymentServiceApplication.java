package com.markcus.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
public class PaymentServiceApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(PaymentServiceApplication.class, args);
	}
	
	
	
}

@RestController
class PaymentController {
	
	@GetMapping
	public String msg() {
		return "Payment controller responding!!";
	}
	
}






