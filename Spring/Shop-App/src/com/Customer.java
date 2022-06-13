package com;

public class Customer {

	public static void main(String[] args) {

		String[] cart1 = { "P001", "P002", "P003" };		
		String[] cart2 = { "P001", "P002"};

		//-----------------------------------------------------------
		PriceMatrixImpl price=new PriceMatrixImpl(); //dependency
		//-----------------------------------------------------------

		BillingServiceImpl biller = new BillingServiceImpl(); // biller
		
		biller.setPrice(price); // Injecting/passing dependency object (price) to the dependent object (biller) is called DI.
		
		double total = biller.getCartTotal(cart1);
		System.out.println("Total for Cart1 is " + total);
		
		total=biller.getCartTotal(cart2);
		System.out.println("Total for Cart2 is " + total);

	}

}
