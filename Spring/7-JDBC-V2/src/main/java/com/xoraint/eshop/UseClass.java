package com.xoraint.eshop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.xoraint.eshop.config.AppConfig;
import com.xoraint.eshop.dao.ProductDao;
import com.xoraint.eshop.dao.ProductDaoImpl;
import com.xoraint.eshop.model.Brand;
import com.xoraint.eshop.model.Category;
import com.xoraint.eshop.model.Product;
import com.xoraint.eshop.service.ProductService;
import com.xoraint.eshop.service.ProductServiceImpl;

public class UseClass {

	public static void main(String[] args) {

		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		
		ProductService productService = ac.getBean(ProductServiceImpl.class);
		productService.findAllProductsV2().forEach(System.out::println);


//		Category c1 = new Category(12);
//		Brand b1 = new Brand(3);
//
//		Product p1 = new Product(8, "iPhone 13 Pro Max", 156000, 12, "i13promax001.jpg", "iPhone 13 Pro Max 256GB Silver",
//				"iphone,iPhone,iPhone13,iPjone13 Pro Max,Pro Max, 13 Pro Max", c1, b1);
//
//		Product prod = prodDao.save(p1);
//		
//		if(prod!=null) {
//			System.out.println("Product saved...");
//		}else {
//			System.out.println("issue while saving.... product not saved..");
//		}
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
