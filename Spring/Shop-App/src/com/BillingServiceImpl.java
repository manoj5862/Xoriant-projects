package com;
//Dependent
public class BillingServiceImpl {
	
	/*
	 * Design issues
	 * -----------------
	 *  -> Too many dependency class object creations.
	 *  	 -> performance issues
	 *  	 -> memory management issues
	 *  
	 *  why this issue happened?
	 *  ---------------------------
	 *  -> dependent class itself creating dependency class object directly
	 *  
	 *  What is the solution?
	 *  -----------------------
	 *  -> Never create dependency class object in the dependent class directly
	 *  -> Instead, use look up technique like JNDI
	 *  -> JNDI location is tightly coupled with dependent class.
	 *  
	 *  
	 *  What is the best solution?
	 *  ------------------------------
	 *  -> Do not create or find / look-up, instead ask some one(container) to inject/pass : IoC
	 * 
	 *   How to implement IoC?
	 *   -----------------------
	 *   -> using dependency injection technique.
	 *   
	 *  What is Dependency Injection: DI
	 *  --------------------------------- 
	 *  -> Injecting/passing dependency object to the dependent object is called DI
	 * 
	 *  In How many ways DI can be implemented? : 2 ways 
	 *  --------------------------------------------
	 *  -> Setter based injection
	 *  -> Constructor based injection
	 *  
	 *  Setter based injection
	 *  ---------------------------
	 *  Rules for defining setter based injection
	 *   1. create reference variable/property of Dependency class in the dependent class at class level
	 *   2. Create setter method for the above defined property. 
	 * 
	 */
	
	
	private PriceMatrixImpl price;
	
	public void setPrice(PriceMatrixImpl price) {
		this.price = price;
	}
	
	public double getCartTotal(String[] cart) {

		double total = 0.0;

		//PriceMatrixImpl price = new PriceMatrixImpl(); // dependency

		for (String itemCode : cart) {
			total = total + price.getItemPrice(itemCode);
		}
		return total;

	}

}
