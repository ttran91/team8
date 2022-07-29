package com.springboot.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orders") //name change because Order is a reserved keyword in SQL


public class Order {
	
	@Id //PK
	@GeneratedValue(strategy = GenerationType.AUTO) //Auto increment
	private Long id;
	
	@Column (length = 255, nullable = false)
	private String orderStatus;
	
	@Column (nullable = true)
	private Double orderCost;
	
	@OneToOne
	private Customer customer;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Order() {
		super();
		
	}

	public Order(Long id, String orderStatus, Double orderCost) {
		super();
		this.id = id;
		this.orderStatus = orderStatus;
		this.orderCost = orderCost;
	}

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

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderStatus=" + orderStatus + ", orderCost=" + orderCost + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}