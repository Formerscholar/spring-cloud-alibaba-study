package com.chad.order.controller;

import com.chad.order.service.Stockservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName: OrderController
 * @Description: OrderController
 * @author: chad
 * @date: 2021/7/13/013 20:52
 */
@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	Stockservice stockservice;
	
	@GetMapping("/add")
	public String add() {
		System.out.println("下单成功！");
		String reduct = stockservice.reduct();
		return "下单成功！" + reduct;
	}
}
