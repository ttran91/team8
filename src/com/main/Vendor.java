package com.main;

public class Vendor {
	private int venID;
	private String venName;
	private String venUsername;
	private String venPassword;
	public Vendor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Vendor(int venID, String venName, String venUsername, String venPassword) {
		super();
		this.venID = venID;
		this.venName = venName;
		this.venUsername = venUsername;
		this.venPassword = venPassword;
	}
	public int getVenID() {
		return venID;
	}
	public void setVenID(int venID) {
		this.venID = venID;
	}
	public String getVenName() {
		return venName;
	}
	public void setVenName(String venName) {
		this.venName = venName;
	}
	public String getVenUsername() {
		return venUsername;
	}
	public void setVenUsername(String venUsername) {
		this.venUsername = venUsername;
	}
	public String getVenPassword() {
		return venPassword;
	}
	public void setVenPassword(String venPassword) {
		this.venPassword = venPassword;
	}
	@Override
	public String toString() {
		return "Vendor [venID=" + venID + ", venName=" + venName + ", venUsername=" + venUsername + ", venPassword="
				+ venPassword + "]";
	}
	

}