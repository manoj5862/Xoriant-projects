package com.xoriant.configclient.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xoriant.configclient.model.Product;

@Service
public class SearchServiceImpl implements SearchService {
	
	@Autowired
	private SearchServiceProxy serviceProxy;

	// find all products

	@Override
	public List<Product> findAll() {
		return serviceProxy.findAll();
	}
	
	@Override
	public Product findById(int id) {
		return serviceProxy.findById(id);
	}

}
