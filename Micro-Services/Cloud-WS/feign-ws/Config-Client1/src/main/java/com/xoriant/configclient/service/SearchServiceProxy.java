package com.xoriant.configclient.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.xoriant.configclient.model.Product;

@FeignClient(name = "search-proxy",url = "http://localhost:9092/api/products")
public interface SearchServiceProxy {
	
	@GetMapping
	public List<Product> findAll();
	@GetMapping("/{id}")
	public Product findById(@PathVariable int id);
	

}
