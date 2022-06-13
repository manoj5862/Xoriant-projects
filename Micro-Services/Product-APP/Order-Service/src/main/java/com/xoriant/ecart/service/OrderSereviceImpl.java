package com.xoriant.ecart.service;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.xoriant.ecart.controller.Sender;
import com.xoriant.ecart.model.ItemLine;
import com.xoriant.ecart.model.Order;

@Service
public class OrderSereviceImpl implements OrderService {

	@Autowired
	private Sender sender;

	private RestTemplate restTemplate = new RestTemplate();

	private static final String BASE_URL = "http://localhost:8082/api/cart/";

	Random rand = new Random();
	protected static SecureRandom random = new SecureRandom();
	int upperbound = 2500000;

	@Override
	public Order placeOrder(String user) { // direct order

		ItemLine[] cartItems = restTemplate.getForObject(BASE_URL + "/" + user, ItemLine[].class);

		double totalAmount = Arrays.stream(cartItems).mapToDouble(line -> (line.getItem().getPrice() * line.getQty()))
				.sum();

		Order order = new Order(6, 1, 1, 3, totalAmount, "8AT7125245323433KK", "Success", LocalDateTime.now());
		
		
		System.out.println(">>>> TOTAL AMOUNT:: " + totalAmount);

		// Send Order Information to the Rabbit MQ
		Map<String, Object> orderInfo = new HashMap<String, Object>();
		orderInfo.put("ORDER_ID", order.getOrderId());
		orderInfo.put("ORDER_DATE", LocalDateTime.now());
		orderInfo.put("TRANSACTION_ID", order.getTransactionId());
		orderInfo.put("TOTAL", order.getTotal());

		// -------------------------------------
		sender.sendOrderDetails(orderInfo);
		// -------------------------------------

		
		// Clear cart items of user
		restTemplate.delete(BASE_URL+"/"+user);
			
		
		return order;

	}

}
