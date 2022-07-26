package com.springboot.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String CustomerName;
	
	@Column
	private String CustomerUsername;
	
	@Column
	private String CustomerPassword;
	
	@Column
	private double CustomerBalance;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(Long id, String customerName, String customerUsername, String customerPassword,
			double customerBalance) {
		super();
		this.id = id;
		CustomerName = customerName;
		CustomerUsername = customerUsername;
		CustomerPassword = customerPassword;
		CustomerBalance = customerBalance;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomerName() {
		return CustomerName;
	}

	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}

	public String getCustomerUsername() {
		return CustomerUsername;
	}

	public void setCustomerUsername(String customerUsername) {
		CustomerUsername = customerUsername;
	}

	public String getCustomerPassword() {
		return CustomerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		CustomerPassword = customerPassword;
	}

	public double getCustomerBalance() {
		return CustomerBalance;
	}

	public void setCustomerBalance(double customerBalance) {
		CustomerBalance = customerBalance;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", CustomerName=" + CustomerName + ", CustomerUsername=" + CustomerUsername
				+ ", CustomerPassword=" + CustomerPassword + ", CustomerBalance=" + CustomerBalance + "]";
	}
	
	
	

}