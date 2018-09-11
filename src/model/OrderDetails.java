package model;

import java.io.Serializable;

public class OrderDetails implements Serializable{
	private int orderDetailID;
	private int quantity;	
	private Products product;
		
	public OrderDetails() {
		
	}

	public int getOrderDetailID() {
		return orderDetailID;	
	}

	public void setOrderDetailID(int orderDetailID) {
		this.orderDetailID = orderDetailID;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

	public Products getProduct() {
		return product;
	}

	public void setProduct(Products product) {
		this.product = product;
	}
	
}
