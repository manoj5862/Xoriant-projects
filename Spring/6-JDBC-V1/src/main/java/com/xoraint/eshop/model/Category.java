package com.xoraint.eshop.model;

public class Category {
	
	private int categoryId;
	private String categoryTitle;
	
	public Category() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	public Category(int categoryId) {
		super();
		this.categoryId = categoryId;
	}





	public Category(int categoryId, String categoryTitle) {
		super();
		this.categoryId = categoryId;
		this.categoryTitle = categoryTitle;
	}


	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryTitle() {
		return categoryTitle;
	}
	public void setCategoryTitle(String categoryTitle) {
		this.categoryTitle = categoryTitle;
	}


	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryTitle=" + categoryTitle + "]";
	}
	
	
	
	

}
