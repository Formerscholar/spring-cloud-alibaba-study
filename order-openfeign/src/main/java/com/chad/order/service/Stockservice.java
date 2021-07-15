package com.chad.order.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "stock-service", path = "/stock")
public interface Stockservice {
	
	@GetMapping("/reduct")
	String reduct();
}
