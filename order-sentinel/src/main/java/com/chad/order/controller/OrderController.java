package com.chad.order.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
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
	
	
	@GetMapping("/add")
	//@SentinelResource(value = "add", blockHandler = "addBlockHandler")
	public String add() {
		System.out.println("下单成功！");
		return "下单成功！";
	}
	
	public String addBlockHandler(BlockException e) {
		System.out.println(e);
		return "流控！";
	}
}
