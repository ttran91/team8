package com.springboot.backend.GP.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="food")
public class Food {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	public Food() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Food(Long id, String foodCategory, double foodPrice, String name, Vendor vendor) {
		super();
		this.id = id;
		this.foodCategory = foodCategory;
		this.foodPrice = foodPrice;
		this.name = name;
		this.vendor = vendor;
	}
	@Override
	public String toString() {
		return "Food [id=" + id + ", foodCategory=" + foodCategory + ", foodPrice=" + foodPrice + ", name=" + name
				+ ", vendor=" + vendor + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFoodCategory() {
		return foodCategory;
	}
	public void setFoodCategory(String foodCategory) {
		this.foodCategory = foodCategory;
	}
	public double getFoodPrice() {
		return foodPrice;
	}
	public void setFoodPrice(double foodPrice) {
		this.foodPrice = foodPrice;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Vendor getVendor() {
		return vendor;
	}
	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}
	//Make sure foodCategory is not NULL
	@Column(nullable = false)
	private String foodCategory;
	//Make sure foodPrice is not NULL
	@Column(nullable = false)
	private double foodPrice;
	@Column(nullable = false)
	private String name;
	//Vendor ID as a foreign key
	@OneToOne
	private Vendor vendor;
	

}
