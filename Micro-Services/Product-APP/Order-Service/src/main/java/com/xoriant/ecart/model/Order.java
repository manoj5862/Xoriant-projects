package com.xoriant.ecart.model;

import java.time.LocalDateTime;

public class Order {

	private int orderId;
	private int productId;
	private int userId;
	private double total;
	private String transactionId;
	private String paymentStatus;
	private int quantity;
	private LocalDateTime orderDate;
	

	public Order() {
		// TODO Auto-generated constructor stub
	}

	public Order(int orderId, int userId,int productId,int quantity, double total, String transactionId, String paymentStatus,LocalDateTime orderDate) {
		this.orderId = orderId;
		this.productId = productId;
		this.userId = userId;
		this.quantity=quantity;
		this.total = total;
		this.transactionId = transactionId;
		this.paymentStatus = paymentStatus;
		this.orderDate=orderDate;
	}
	
	

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", productId=" + productId + ", userId=" + userId + ", total=" + total
				+ ", transactionId=" + transactionId + ", paymentStatus=" + paymentStatus + ", quantity=" + quantity
				+ "]";
	}
	
	

}
