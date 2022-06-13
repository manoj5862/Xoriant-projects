package com.xoriant.receiver.controller;

import java.util.Map;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Reciver {

	@RabbitListener(queues = "Q1")
	public void readMessage(String msg) {

		System.out.println("============================================");
		System.out.println(">>>>> Receiving Mesasage:: " + msg);
		System.out.println("============================================");
	}
	
	
	@RabbitListener(queues = "Q2")
	public void readData(Map<String, Object> ordrerInfo) {

		System.out.println("============================================");
		
		System.out.println("Product ID: "+ordrerInfo.get("PID"));
		System.out.println("Product Quantity: "+ordrerInfo.get("QTY"));
		System.out.println("Product Price: "+ordrerInfo.get("PRICE"));
		System.out.println("Order Date: "+ordrerInfo.get("DATE"));
		System.out.println("Order Time: "+ordrerInfo.get("TIME"));
		
		System.out.println("============================================");
	}

}
