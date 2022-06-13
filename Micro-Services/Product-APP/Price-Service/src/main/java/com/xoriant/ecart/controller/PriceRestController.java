package com.xoriant.ecart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xoriant.ecart.service.PriceService;

@RestController
@RequestMapping("/api/price")
@CrossOrigin
public class PriceRestController {
	
	@Autowired
	private PriceService priceService;
	
	@GetMapping("/{productId}")
	public double getItemPrice(@PathVariable int productId) {
		return priceService.getItemPrice(productId);
	}
	
	
	

}
