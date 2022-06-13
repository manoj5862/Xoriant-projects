package com.xoriant.ecart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.xoriant.ecart.dao.ProductDao;
import com.xoriant.ecart.dao.ProductDaoImpl;
import com.xoriant.ecart.model.Product;
import com.xoriant.ecart.service.ProductService;
import com.xoriant.ecart.service.ProductServiceImpl;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		
		ApplicationContext ac = SpringApplication.run(Application.class, args);
		ProductService prodDao = ac.getBean(ProductServiceImpl.class);

		// prodDao.findAll().forEach(System.out::println);
		/*
		Product product = prodDao.findById(1);
		if (product != null) {
			System.out.println(product);
		} else {
			System.out.println("product ID doesnt find in DB");
		}
		*/
		
		//prodDao.findAllByProductName("%max%").forEach(System.out::println);
		//prodDao.findAllproductByPriceRange(15000, 40000).forEach(System.out::println);
		//prodDao.findAllproductByMaxPrice(22000).forEach(System.out::println);
		//prodDao.findAllProductsByBrandName("Apple").forEach(System.out::println);
		//prodDao.filterBrandsByCategoryName("Mobiles").forEach(System.out::println);
		prodDao.filterBrandNameByCategoryName("Mens Wear").forEach(System.out::println);

	}

}
