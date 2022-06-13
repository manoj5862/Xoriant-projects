package com.xoriant.ecart.controller;

import java.util.Map;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

import com.xoriant.ecart.service.ProductService;

@Controller
public class Receiver {
	
	
	

	@Autowired
	private ProductService ps;
	
	RabbitTemplate rt=new RabbitTemplate();
	
	@Bean
	public Queue f1() {
		return new Queue("InventoryQ",false);
	}
	
	
	@RabbitListener(queues = "InventoryQ")
	public void updateInventory(Map<String, Object> details) {

		int productId = (int) details.get("PID");
		int qty = (int) details.get("QTY");

		ps.updateInventory(productId, qty);

	}

}
