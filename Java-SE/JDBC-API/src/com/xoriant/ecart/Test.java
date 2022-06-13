package com.xoriant.ecart;

import com.xoriant.ecart.dao.ProductDaoImpl;
import com.xoriant.ecart.model.Product;

public class Test {

	public static void main(String[] args) {

		System.out.println(">>> main <<<");

		Product p1 = new Product(12, "Laptop", 35000, "HP I3 Laptop");
		ProductDaoImpl prodDao = new ProductDaoImpl();
		// prodDao.saveV1(p1);
		//prodDao.findAll().forEach(System.out::println);
		//prodDao.findAllV2();
		
		prodDao.operations();

	}

}
