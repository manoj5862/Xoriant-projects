package com.xoriant.ecart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xoriant.ecart.dao.ProductDao;
import com.xoriant.ecart.model.Product;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductDao prodDao;

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return prodDao.findAll();
	}

	@Override
	public Product findById(int productId) {
		// TODO Auto-generated method stub
		return prodDao.findById(productId);
	}

	@Override
	public List<Product> findAllByProductName(String productName) {
		// TODO Auto-generated method stub
		return prodDao.findAllByProductName(productName);
	}

	@Override
	public List<Product> findAllProductByPriceRange(double minPrice, double maxPrice) {
		// TODO Auto-generated method stub
		return prodDao.findAllProductByPriceRange(minPrice, maxPrice);
	}

	@Override
	public List<Product> findAllProductByMaxPrice(double maxPrice) {
		// TODO Auto-generated method stub
		return prodDao.findAllProductByMaxPrice(maxPrice);
	}

	@Override
	public List<Product> findAllProductsByBrandName(String brandName) {
		// TODO Auto-generated method stub
		return prodDao.findAllProductsByBrandName(brandName);
	}

	@Override
	public List<Product> filterBrandsByCategoryName(String categoryName) {
		// TODO Auto-generated method stub
		return prodDao.filterBrandsByCategoryName(categoryName);
	}

	@Override
	public List<String> filterBrandNameByCategoryName(String categoryName) {
		// TODO Auto-generated method stub
		return prodDao.filterBrandNameByCategoryName(categoryName);
	}
	
	

}
