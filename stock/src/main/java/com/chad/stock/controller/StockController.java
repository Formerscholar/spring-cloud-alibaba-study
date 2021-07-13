package com.chad.stock.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: StockController
 * @Description: StockController
 * @author: chad
 * @date: 2021/7/13/013 20:56
 */
@RestController
@RequestMapping("/stock")
public class StockController {
	
	@GetMapping("/reduct")
	public String reduct() {
		System.out.println("扣减库存!");
		return "扣减库存";
	}
}
