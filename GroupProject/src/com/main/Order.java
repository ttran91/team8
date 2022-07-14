package com.main;

public class Order {
	private int orderID;
	private String orderStatus;
	private double orderCost;
	private int idCustomer;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(int orderID, String orderStatus, double orderCost, int idCustomer) {
		super();
		this.orderID = orderID;
		this.orderStatus = orderStatus;
		this.orderCost = orderCost;
		this.idCustomer = idCustomer;
	}
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public double getOrderCost() {
		return orderCost;
	}
	public void setOrderCost(double orderCost) {
		this.orderCost = orderCost;
	}
	public int getIdCustomer() {
		return idCustomer;
	}
	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}
	@Override
	public String toString() {
		return "Order [orderID=" + orderID + ", orderStatus=" + orderStatus + ", orderCost=" + orderCost
				+ ", idCustomer=" + idCustomer + "]";
	}
	
	

}
