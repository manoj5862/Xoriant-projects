package com.xoriant.configclient.service;

import java.util.List;

import com.xoriant.configclient.model.Product;

public interface SearchService {

	List<Product> findAll();

	Product findById(int id);

}