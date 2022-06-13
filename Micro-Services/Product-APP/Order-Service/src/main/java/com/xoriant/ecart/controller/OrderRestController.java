package com.xoriant.ecart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xoriant.ecart.model.Order;
import com.xoriant.ecart.service.OrderService;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin
public class OrderRestController {
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/{user}")
	public Order placeOrder(@PathVariable String user) {
		return orderService.placeOrder(user);
	}
	
	

}
