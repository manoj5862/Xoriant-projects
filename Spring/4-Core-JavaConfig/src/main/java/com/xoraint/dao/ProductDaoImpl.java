package com.xoraint.dao;

import org.springframework.stereotype.Repository;

@Repository
public class ProductDaoImpl implements ProductDao {

	public ProductDaoImpl() {
		System.out.println("ProductDaoImpl object created..");
	}

	@Override
	public void save() {
		System.out.println(">>>>> dao::: database logic");

		System.out.println(">>> saving product");

	}

}
