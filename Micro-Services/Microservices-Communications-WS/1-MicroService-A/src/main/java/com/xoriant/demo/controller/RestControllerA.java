package com.xoriant.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xoriant.demo.model.Product;

@RestController
@RequestMapping("/api/products")
public class RestControllerA {

	private static List<Product> products = new ArrayList<>();

	static {
		Product p1 = new Product(10, "Pen", 1000);
		Product p2 = new Product(11, "Book", 4500);
		Product p3 = new Product(12, "Laptop", 34000);
		Product p4 = new Product(13, "Mobile", 12000);
		Product p5 = new Product(14, "Mouse", 1876);
		products.add(p1);
		products.add(p2);
		products.add(p3);
		products.add(p4);
		products.add(p5);

	}
	
	@GetMapping("/greet")
	public String greet() {
		return "Greet Message form MicroServiceA";
	}

	
	@GetMapping
	public List<Product> findAllProducts(){
		return products;
	}
	
	@GetMapping("/{id}")
	public Product findById(@PathVariable int id) {
		System.out.println("ID:: "+id);
		return products.stream().filter(product->product.getId()==id).findAny().orElse(null);
	}	

}
