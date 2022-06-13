package com.xoraint.eshop.model;

public class Product {

	private int productId;
	private String productName;
	private double price;
	private int quantity;
	private String imagePath;
	private String description;
	private String keywords;
	
	private Category category;
	private Brand brand;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	public Product(int productId, String productName, double price, int quantity, String imagePath, String description,
			String keywords, Category category, Brand brand) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
		this.imagePath = imagePath;
		this.description = description;
		this.keywords = keywords;
		this.category = category;
		this.brand = brand;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", price=" + price + ", quantity="
				+ quantity + ", imagePath=" + imagePath + ", description=" + description + ", keywords=" + keywords
				+ ", category=" + category + ", brand=" + brand + "]";
	}

	
	

}
