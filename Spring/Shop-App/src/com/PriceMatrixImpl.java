package com;

//Dependency
public class PriceMatrixImpl {
	
	/*
	 * Types of Objects 
	 * ====================
	 *    1. Dependency object: never depends on any other objects: independent
	 *    2. Dependent object: always depends on dependency objects
	 * 
	 */

	public PriceMatrixImpl() {
		System.out.println(">>> PriceMatrixImpl:: object created..");
	}

	public double getItemPrice(String itemCode) {
		// code to connect to the DB and fetch item price of given itemCode
		return 100.00;

	}

}
