package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Dependent
@Service
public class BillingServiceImpl {
	
	@Autowired
	private PriceMatrixImpl price;

	public double getCartTotal(String[] cart) {

		double total = 0.0;

		//PriceMatrixImpl price = new PriceMatrixImpl(); // dependency

		for (String itemCode : cart) {
			total = total + price.getItemPrice(itemCode);
		}
		return total;

	}

}
