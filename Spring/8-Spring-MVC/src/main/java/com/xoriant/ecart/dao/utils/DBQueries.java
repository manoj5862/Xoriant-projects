package com.xoriant.ecart.dao.utils;

public class DBQueries {
	
	public static final String PRODUCT_SAVE="insert into products values(?,?,?,?,?,?,?,?,?)";
	public static final String LIST_ALL_PRODUCTS="select * from products";
	public static final String FIND_PRODUCT_BY_ID="select * from products where product_id=?";
	public static final String FIND_PRODUCTS_By_NAME="select * from products where product_title like ?";
	

	/*
	 * 
	 *   
	 *    
	 *    	Sub images can be saved as String array in the same table.
	 *    	Product ID itself act like image path
	 *      100011IMG1.JPG,100011IMG2.JPG,100011IMG3.JPG
	 *      
	 *      
	 *      
	 *      --> BeanPropertyRowMapper
	 *      --> SetDatatype
	 *      
	 *      
	 * 
	 * 
	 * 
	 */
	
	
	
	
	
	
	
}
