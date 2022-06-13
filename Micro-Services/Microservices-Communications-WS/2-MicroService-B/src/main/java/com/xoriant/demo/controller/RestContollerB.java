package com.xoriant.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.xoriant.demo.model.Product;

@RestController
@RequestMapping("/api/search")
@CrossOrigin
public class RestContollerB {
	
	
	private RestTemplate rt=new RestTemplate();
	
	@GetMapping("/s1")
	public String getMessage() {
		String msg=rt.getForObject("http://localhost:9090/api/products/greet", String.class);
		return msg;
	}
	
	
	@GetMapping
	public List<Product> listAll(){
		List<Product> prods= rt.getForObject("http://localhost:9090/api/products", List.class);
		return prods;
	}
	
	@GetMapping("/{id}")
	public Product findById(@PathVariable int id) {
		Product prod=rt.getForObject("http://localhost:9090/api/products/"+id, Product.class);
		return prod;
		
	}
	
	
	
	
	
	

}
