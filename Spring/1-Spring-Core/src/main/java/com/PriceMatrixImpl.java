package com;

import org.springframework.stereotype.Repository;

//Dependency
@Repository
public class PriceMatrixImpl {


	public PriceMatrixImpl() {
		//System.out.println(">>> PriceMatrixImpl:: object created..");
	}

	public double getItemPrice(String itemCode) {
		// code to connect to the DB and fetch item price of given itemCode
		return 100.00;

	}

}
