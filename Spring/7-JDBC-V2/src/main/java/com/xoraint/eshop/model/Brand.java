package com.xoraint.eshop.model;

public class Brand {

	private int brandId;
	private String brandTitle;

	public Brand() {
		// TODO Auto-generated constructor stub
	}

	public Brand(int brandId) {
		super();
		this.brandId = brandId;
	}

	public Brand(int brandId, String brandTitle) {
		super();
		this.brandId = brandId;
		this.brandTitle = brandTitle;
	}

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public String getBrandTitle() {
		return brandTitle;
	}

	public void setBrandTitle(String brandTitle) {
		this.brandTitle = brandTitle;
	}

	@Override
	public String toString() {
		return "Brand [brandId=" + brandId + ", brandTitle=" + brandTitle + "]";
	}

}
