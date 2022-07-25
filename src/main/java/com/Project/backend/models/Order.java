package com.Project.backend.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders") //name change because Order is a reserved keyword in SQL


public class Order {
	
	@Id //PK
	@GeneratedValue(strategy = GenerationType.AUTO) //Auto increment
	private Long id;
	
	@Column (length = 255, nullable = false)
	private String orderName;
	
	@Column (nullable = true)
	private Integer orderPreference;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public Integer getOrderPreference() {
		return orderPreference;
	}

	public void setOrderPreference(Integer orderPreference) {
		this.orderPreference = orderPreference;
	}

	public Order(Long id, String orderName, Integer orderPreference) {
		super();
		this.id = id;
		this.orderName = orderName;
		this.orderPreference = orderPreference;
	}

	public Order() {
		super();
		
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderName=" + orderName + ", orderPreference=" + orderPreference + "]";
	} 
	
	
	
	
	
	
	
	
	
	
	

}
