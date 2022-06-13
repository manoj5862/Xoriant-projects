package com.xoriant.ecart.model;

public class ItemLine {

	private Item item;
	private int qty;
	private double totalPrice;

	public ItemLine() {
		// TODO Auto-generated constructor stub
	}

	public ItemLine(Item item, int qty) {
		super();
		this.item = item;
		this.qty = qty;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "ItemLine [item=" + item + ", qty=" + qty + "]";
	}

}
