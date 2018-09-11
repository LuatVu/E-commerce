package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Orders implements Serializable{
	private int orderID;
	private Date orderDate;
	private Customers customer;
	private Employees employee;
	private Shippers shipper;
	private ArrayList<OrderDetails> orderDetail;
	
	public Orders() {}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Customers getCustomer() {
		return customer;
	}

	public void setCustomer(Customers customer) {
		this.customer = customer;
	}

	public Employees getEmployee() {
		return employee;
	}

	public void setEmployee(Employees employee) {
		this.employee = employee;
	}

	public Shippers getShipper() {
		return shipper;
	}

	public void setShipper(Shippers shipper) {
		this.shipper = shipper;
	}

	public ArrayList<OrderDetails> getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(ArrayList<OrderDetails> orderDetail) {
		this.orderDetail = orderDetail;
	}	
}
