package com.springboot.backend.DTO;

public class OrderDto{
	
	private Long id;
	private String orderStatus;
	private Double orderCost;
	private Long cid;
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
