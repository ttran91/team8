package com.springboot.backend.GP.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String CustomerName;
	
	@Column
	private String CustomerPhone;
	
	@Column
	private String CustomerEmail;
	
	@Column
	private double CustomerBalance;
	
	@OneToOne
	private UserInfo userInfo;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(Long id, String customerName, String customerPhone, String customerEmail, double customerBalance,
			UserInfo userInfo) {
		super();
		this.id = id;
		CustomerName = customerName;
		CustomerPhone = customerPhone;
		CustomerEmail = customerEmail;
		CustomerBalance = customerBalance;
		this.userInfo = userInfo;
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

	public String getCustomerPhone() {
		return CustomerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		CustomerPhone = customerPhone;
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

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", CustomerName=" + CustomerName + ", CustomerPhone=" + CustomerPhone
				+ ", CustomerEmail=" + CustomerEmail + ", CustomerBalance=" + CustomerBalance + ", userInfo=" + userInfo
				+ "]";
	}
	
	

	
	
	

}
