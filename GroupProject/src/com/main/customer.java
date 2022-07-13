package com.main;

public class customer {
	private int id;
	private String custName;
	private String userName;
	private String Password;
	private double custBalance;
	public customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public customer(int id, String custName, String userName, String password, double custBalance) {
		super();
		this.id = id;
		this.custName = custName;
		this.userName = userName;
		Password = password;
		this.custBalance = custBalance;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public double getCustBalance() {
		return custBalance;
	}
	public void setCustBalance(double custBalance) {
		this.custBalance = custBalance;
	}
	@Override
	public String toString() {
		return "customer [id=" + id + ", custName=" + custName + ", userName=" + userName + ", Password=" + Password
				+ ", custBalance=" + custBalance + "]";
	}
	
	

}
