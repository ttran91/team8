package com.springboot.backend.GP.dto;

import com.springboot.backend.GP.enums.AccountType;
import com.springboot.backend.GP.model.UserInfo;

public class CustomerDto {
	private long id;
	private String CustomerName;
	private String CustomerNumber;
	private String CustomerEmail;
	private double CustomerBalance;
	private long uid;
	private String uUsername;
	private String uPassword;
	private AccountType uAccountType;
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
	public long getUid() {
		return uid;
	}
	public void setUid(long uid) {
		this.uid = uid;
	}
	public String getuUsername() {
		return uUsername;
	}
	public void setuUsername(String uUsername) {
		this.uUsername = uUsername;
	}
	public String getuPassword() {
		return uPassword;
	}
	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}
	public AccountType getuAccountType() {
		return uAccountType;
	}
	public void setuAccountType(AccountType uAccountType) {
		this.uAccountType = uAccountType;
	}
	

}
