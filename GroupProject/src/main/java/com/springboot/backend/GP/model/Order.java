package com.springboot.backend.GP.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
	@Id // PK
	@GeneratedValue(strategy = GenerationType.AUTO) // Auto increment
	private Long id;

	@Column(length = 255, nullable = false)
	private String orderStatus;

	@Column(nullable = true)
	private Double orderCost;

	@OneToOne
	private Customer customer; // FK

	@OneToOne
	private Vendor vendor;

	public Order() {
		super();

	}

	public Order(Long id, String orderStatus, Double orderCost, Customer customer, Vendor vendor) {
		super();
		this.id = id;
		this.orderStatus = orderStatus;
		this.orderCost = orderCost;
		this.customer = customer;
		this.vendor = vendor;
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderStatus=" + orderStatus + ", orderCost=" + orderCost + ", customer="
				+ customer + ", vendor=" + vendor + "]";
	}

}
