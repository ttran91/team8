package com.springboot.backend.GP.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "inventory")
public class Inventory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private int amountInStock;

	@Column(length = 255, nullable = false)
	private String outOfStockExp;

	@Column(nullable = false)
	private int maxStock;

	private LocalDate dateAdded;

	@OneToOne
	private Food food;

	@OneToOne
	private Vendor vendor;

	public Inventory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Inventory(Long id, int amountInStock, String outOfStockExp, int maxStock, LocalDate dateAdded, Food food,
			Vendor vendor) {
		super();
		this.id = id;
		this.amountInStock = amountInStock;
		this.outOfStockExp = outOfStockExp;
		this.maxStock = maxStock;
		this.dateAdded = dateAdded;
		this.food = food;
		this.vendor = vendor;
	}

	@Override
	public String toString() {
		return "Inventory [id=" + id + ", amountInStock=" + amountInStock + ", outOfStockExp=" + outOfStockExp
				+ ", maxStock=" + maxStock + ", dateAdded=" + dateAdded + ", food=" + food + ", vendor=" + vendor + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getAmountInStock() {
		return amountInStock;
	}

	public void setAmountInStock(int amountInStock) {
		this.amountInStock = amountInStock;
	}

	public String getOutOfStockExp() {
		return outOfStockExp;
	}

	public void setOutOfStockExp(String outOfStockExp) {
		this.outOfStockExp = outOfStockExp;
	}

	public int getMaxStock() {
		return maxStock;
	}

	public void setMaxStock(int maxStock) {
		this.maxStock = maxStock;
	}

	public LocalDate getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(LocalDate dateAdded) {
		this.dateAdded = dateAdded;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

}
