package com.xoriant.product.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xoriant.product.model.Product;

@RestController
@RequestMapping("/api/products")
@RefreshScope
@CrossOrigin
public class Service1RestController {
	static List<Product> products = null;
	
	@Value("${name}")
	private String personName;
	
	
	static {
		products = new ArrayList<>();
		Product p1 = new Product(1, "Pen", 18, "Red Ink");
		Product p2 = new Product(2, "Book", 450, "Java Book");
		Product p3 = new Product(3, "Moibile", 12000, "Samsung A2");
		Product p4 = new Product(4, "Laptop", 65000, "Aser I3 Gen6");
		Product p5 = new Product(4, "Pen Drive", 1287, "128 Sandisk");

		products.add(p1);
		products.add(p2);
		products.add(p3);
		products.add(p4);
		products.add(p5);

	}

	@GetMapping("/greet")
	public String f1() {
		System.out.println("===================================");
		System.out.println(">>>>>> SEARCH-SERVICE-3 <<<<<<");
		System.out.println("===================================");
		return "Hello "+personName+"! Good Morning";
	}
	
	// find a product
	@GetMapping("/{id}")
	public Product findById(@PathVariable int id) {
		System.out.println("===================================");
		System.out.println(">>>>>> SEARCH-SERVICE-3 <<<<<<");
		System.out.println("===================================");
		return products.stream().filter(product->product.getId()==id).findAny().orElse(null);
	}
	
	@GetMapping
	public List<Product> findAll(){
		System.out.println("===================================");
		System.out.println(">>>>>> SEARCH-SERVICE-3 <<<<<<");
		System.out.println("===================================");
		return products;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
