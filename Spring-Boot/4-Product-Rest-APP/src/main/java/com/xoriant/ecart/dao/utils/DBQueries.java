package com.xoriant.ecart.dao.utils;

public class DBQueries {
	
	public final static String FIND_PRODUCT_BY_PRODUCTID="select * from products p inner join brands b on p.product_brand=b.brand_id inner join categories c on p.product_cat = c.cat_id where p.product_id=?";
	public final static String FIND_PRODUCT_BY_PRODUCTNAME="select * from products p inner join brands b on p.product_brand=b.brand_id inner join categories c on p.product_cat = c.cat_id where p.product_title like ?";
	public final static String FIND_PROODUCTS_BY_CATEGORY = "select * from products p inner join brands b on p.product_brand=b.brand_id inner join categories c on p.product_cat = c.cat_id where p.product_cat=?";
	public static final String FIND_ALL_PRODUCTS="select * from products p inner join brands b on p.product_brand=b.brand_id inner join categories c on p.product_cat = c.cat_id";
	public static final String FILTER_PRODUCTS_BY_MIN_MAX="select * from products p inner join brands b on p.product_brand=b.brand_id inner join categories c on p.product_cat = c.cat_id where p.product_price >=? and p.product_price<=?";
	public static final String FILTER_PRICE_MAX_RANGE="select * from products p inner join brands b on p.product_brand=b.brand_id inner join categories c on p.product_cat = c.cat_id where p.product_price >=?";
	public static final String FILTER_PRODUCTS_BY_BRAND="select * from products p inner join  brands b ON p.product_brand=b.brand_id where b.brand_title like ?";
	public static final String FIND_BRAND_NAMES="select * from brands";
	public static final String FILTER_PRODUCTS_By_BRANDNAME="select * from products p join brands b on p.product_brand = b.brand_id join categories c on p.product_cat = c.cat_id where b.brand_title like ?";
	public static final String FIND_ALL_CATEGORIES="select * from categories";
	public static final String FILTER_PRODUCTS_BY_CATEGORYNAME="select  *  from products p inner join categories c on p.product_cat=c.cat_id inner join brands  b on p.product_brand = b.brand_id where c.cat_title like ?";
	public static final String FILTER_BRANDNAME_BY_CATEGORYNAME="select  brand_title from brands b inner join brands_info  bi on b.brand_id = bi.brand_id inner join categories c on c.cat_id = bi.cat_id where c.cat_title like ?";

	
	public static final String SAVE_NEW_PRODUCT="insert into products values(?,?,?,?,?,?,?,?,?)";
	
	

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
