package com;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Test {

	public static void main(String[] args) {
		
		System.out.println(">>> main ");

		String[] cart1 = { "P001", "P002", "P003" };
		String[] cart2 = { "P001", "P002" };

		AbstractApplicationContext ac = new AnnotationConfigApplicationContext(AppConfiig.class);

//		BillingServiceImpl biller = ac.getBean(BillingServiceImpl.class);
//		
//		AppConfiig ap1 = ac.getBean(AppConfiig.class);
//		AppConfiig ap2 = ac.getBean(AppConfiig.class);
//		
//		ap1.salary=2400;
//		
//		System.out.println("ap1 on "+System.identityHashCode(ap1));
//		System.out.println("ap2 on "+System.identityHashCode(ap2));
//		System.out.println("Salary:: "+ap2.salary);
//

		
//		double total = biller.getCartTotal(cart1);
//		System.out.println("Cart1 Total:: " + total);
//
//		total = biller.getCartTotal(cart2);
//		System.out.println("Cart2 Total:: " + total);
		
		ac.close();

	}

}
