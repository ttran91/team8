package com.springboot.backend.GP.dto;

public class CustomerDto {
	private long id;
	private String CustomerName;
	private String CustomerNumber;
	private String CustomerEmail;
	private double CustomerBalance;
	
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCustomerName() {
		return CustomerName;
	}
	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}
	public String getCustomerNumber() {
		return CustomerNumber;
	}
	public void setCustomerNumber(String customerNumber) {
		CustomerNumber = customerNumber;
	}
	public String getCustomerEmail() {
		return CustomerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		CustomerEmail = customerEmail;
	}
	public double getCustomerBalance() {
		return CustomerBalance;
	}
	public void setCustomerBalance(double customerBalance) {
		CustomerBalance = customerBalance;
	}
	
	

}
