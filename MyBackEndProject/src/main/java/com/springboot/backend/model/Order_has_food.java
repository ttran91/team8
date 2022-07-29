package com.springboot.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity  //means a class can be mapped to a table
public class Order_has_food {
	@Id //PK
	@GeneratedValue(strategy = GenerationType.AUTO) //Auto increment
	private Long id;
	
	@Column (nullable = true)
	private String food_id;

	
	@OneToOne
	private Order order; //FK

	
	/*
	@OneToOne
	private Food food; //FK
	*/
	
	
	public Order_has_food() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Order_has_food(Long id, String orderId, String food_id, Order order) {
		super();
		this.id = id;
		this.food_id = food_id;
		this.order = order;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}



	public String getFood_id() {
		return food_id;
	}


	public void setFood_id(String food_id) {
		this.food_id = food_id;
	}


	public Order getOrder() {
		return order;
	}


	public void setOrder(Order order) {
		this.order = order;
	}


	@Override
	public String toString() {
		return "OrderHasFood [id=" + id + ", food_id=" + food_id + ", order=" + order + "]";
	}
	
	
	
	

	










}
