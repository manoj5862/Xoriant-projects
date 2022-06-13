package com.xoriant.ecart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xoriant.ecart.model.Product;
import com.xoriant.ecart.service.ProductService;

@RestController
@RequestMapping("/api/products")
@CrossOrigin()
public class ProductRestController {

	@Autowired
	private ProductService productService;

	// save product
	@PostMapping
	public Product save(@RequestBody Product product) {
		return productService.save(product);
	}

	// find all products
	@GetMapping
	public List<Product> findAll() {
		return productService.findAll();
	}

	// find by ID
	@GetMapping("/{productId}")
	public Product findById(@PathVariable int productId) {
		return productService.findById(productId);
	}

	// find by ID - V1
	@GetMapping("/v1/{productId}")
	public ResponseEntity<?> findByIdV1(@PathVariable int productId) {

		Product product = productService.findById(productId);

		if (product != null) {
			return new ResponseEntity<Product>(product, HttpStatus.OK);
		}

		return new ResponseEntity<>("Product ID " + productId + " Does not present ion database", HttpStatus.OK);

	}

	// find all products by product name
	@GetMapping("/filter/{productName}")
	public List<Product> findProductsByName(@PathVariable String productName) {
		return productService.findAllByProductName("%" + productName + "%");
	}

	// find all products by max price
	@GetMapping("/filter/price/{maxPrice}")
	public List<Product> findAllProductsByMaxPrice(@PathVariable double maxPrice) {
		return productService.findAllProductByMaxPrice(maxPrice);
	}

	// find all products by min and max price
	@GetMapping("/filter/price/{minPrice}/{maxPrice}")
	public List<Product> findAllProductsByMinAndMaxPrice(@PathVariable double minPrice, @PathVariable double maxPrice) {
		return productService.findAllProductByPriceRange(minPrice, maxPrice);
	}

	// find all products by brand name
	@GetMapping("/filter/brand/{brandName}")
	public List<Product> findProductsByBrandName(@PathVariable String brandName) {
		return productService.findAllProductsByBrandName(brandName);
	}

	// find all products by category name
	@GetMapping("/filter/category/{categoryName}")
	public List<Product> findProductsByCategoryName(@PathVariable String categoryName) {
		return productService.filterBrandsByCategoryName(categoryName);
	}

	// find all brand names by categorry name
	@GetMapping("/filter/category-name/{categoryName}")
	public List<String> findAllBrandNamesByCategoryName(@PathVariable String categoryName) {
		return productService.filterBrandNameByCategoryName(categoryName);
	}

}
