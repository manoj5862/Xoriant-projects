package com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.xoraint.config.AppConfig;
import com.xoraint.service.ProductService;
import com.xoraint.service.ProductServiceImpl;

public class Test {

	public static void main(String[] args) {

		System.out.println(">>> main <<<");

		// AbstractApplicationContext ac = new
		// ClassPathXmlApplicationContext("spring.xml");
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

		ProductService ps = ac.getBean(ProductServiceImpl.class);
		ps.save();

	}

}
