package com.markcus.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
public class ShippingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShippingServiceApplication.class, args);
	}
	
	
	
}

@RestController
class ShippingController {
	
	@GetMapping
	public String msg() {
		return "shipping controller responding!!";
	}
	
}






