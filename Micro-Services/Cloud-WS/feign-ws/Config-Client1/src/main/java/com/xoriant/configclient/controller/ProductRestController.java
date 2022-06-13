package com.xoriant.configclient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xoriant.configclient.model.Product;
import com.xoriant.configclient.service.SearchService;

@RestController
@RequestMapping("/api/products")
@CrossOrigin
@RefreshScope
public class ProductRestController {
	@Autowired
	private SearchService searchService;
	
	// find all products
	@GetMapping
	public List<Product> findAll(){
		return searchService.findAll();
	}
	
	// find product by ID
	@GetMapping("/{id}")
	public Product findById(@PathVariable int id) {
		return searchService.findById(id);
	}
	

}
