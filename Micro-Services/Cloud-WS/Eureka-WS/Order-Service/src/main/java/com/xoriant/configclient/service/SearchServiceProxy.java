package com.xoriant.configclient.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.xoriant.configclient.model.Product;

@FeignClient(name = "search-service") // http://search-service/api/products

public interface SearchServiceProxy {
	
	@GetMapping("/api/products")
	public List<Product> findAll();
	@GetMapping("/api/products/{id}")
	public Product findById(@PathVariable int id);
	

}
