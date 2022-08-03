package com.springboot.backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity  //means a class can be mapped to a table
@Table(name="OrderHasFood")
public class Order_has_food {
	@Id //PK
	@GeneratedValue(strategy = GenerationType.AUTO) //Auto increment
	private Long id;
	
	@OneToOne
	private Order order; //FK

	
	
	@OneToOne
	private Food food; //FK



	public Order_has_food() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Order_has_food(Long id, Order order, Food food) {
		super();
		this.id = id;
		this.order = order;
		this.food = food;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Order getOrder() {
		return order;
	}



	public void setOrder(Order order) {
		this.order = order;
	}



	public Food getFood() {
		return food;
	}



	public void setFood(Food food) {
		this.food = food;
	}



	@Override
	public String toString() {
		return "Order_has_food [id=" + id + ", order=" + order + ", food=" + food + "]";
	}

	


}