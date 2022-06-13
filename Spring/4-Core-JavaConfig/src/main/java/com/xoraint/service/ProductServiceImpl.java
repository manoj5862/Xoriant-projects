package com.xoraint.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xoraint.dao.ProductDao;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao prodDao;

	public ProductServiceImpl() {
		System.out.println("ProductServiceImpl  object created..");
	}
	
	
	@Override
	public void save() {
		System.out.println(">>>>> service::: java logic");
		prodDao.save();
	}

}
