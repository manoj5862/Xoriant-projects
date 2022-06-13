package com.xoriant.ecart.service;

import java.util.List;

import com.xoriant.ecart.model.Product;

public interface ProductService {
	// fetch all products
	List<Product> findAll();

	// Find a Product by Product ID
	Product findById(int productId);

	// Filter Products by Product Name
	List<Product> findAllByProductName(String productName);

	// Filter Products by Product Price range (min and max)
	List<Product> findAllProductByPriceRange(double minPrice, double maxPrice);

	// Filter Products by Product Max Price
	List<Product> findAllProductByMaxPrice(double maxPrice);

	// Filter Products by Brand name
	List<Product> findAllProductsByBrandName(String brandName);

	// Filter Brands by Category Name
	List<Product> filterBrandsByCategoryName(String categoryName);

	// Filter Brand Names by Category-Name
	List<String> filterBrandNameByCategoryName(String categoryName);

}
