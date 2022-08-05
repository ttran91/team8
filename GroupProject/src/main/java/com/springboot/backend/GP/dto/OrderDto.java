package com.springboot.backend.GP.dto;

public class OrderDto {
	private Long id;
	private String orderStatus;
	private Double orderCost;
	private Long cid;
	private String CName;
	private String CPhone;
	private String CEmail;
	private double CBalance;
	public String getCName() {
		return CName;
	}
	public void setCName(String cName) {
		CName = cName;
	}
	public String getCPhone() {
		return CPhone;
	}
	public void setCPhone(String cPhone) {
		CPhone = cPhone;
	}
	public String getCEmail() {
		return CEmail;
	}
	public void setCEmail(String cEmail) {
		CEmail = cEmail;
	}
	public double getCBalance() {
		return CBalance;
	}
	public void setCBalance(double cBalance) {
		CBalance = cBalance;
	}
	private Long vid;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public Double getOrderCost() {
		return orderCost;
	}
	public void setOrderCost(Double orderCost) {
		this.orderCost = orderCost;
	}
	public Long getCid() {
		return cid;
	}
	public void setCid(Long cid) {
		this.cid = cid;
	}
	public Long getVid() {
		return vid;
	}
	public void setVid(Long vid) {
		this.vid = vid;
	}

}
