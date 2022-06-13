package com.xoriant.sender.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Sender {
	
	@Autowired
	private RabbitTemplate rt;
	
	
	@Bean
	public Queue f1() {
		return new Queue("Q1",false);
	}
	
	@Bean
	public Queue f3() {
		return new Queue("Q2",false);
	}
	
	@GetMapping
	public String f2() {
		
		rt.convertAndSend("Q1","Message from Microservice-Sender-4");
		
		return "Message Wittern to Rabbit MQ Q1";
	}
	
	@GetMapping("/data")
	public String f4() {
		
		Map<String, Object> data=new HashMap<String, Object>();
		
		data.put("PID", "P001");
		data.put("QTY", 3);
		data.put("PRICE", 4500);
		data.put("DATE", LocalDate.now());
		data.put("TIME", LocalTime.now());
		
		rt.convertAndSend("Q2",data);
		
		
		
		return "Message Wittern to Rabbit MQ >>>  Q2";
	}
	
	

}
