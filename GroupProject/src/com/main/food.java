package com.main;

public class food {
	
	private int id;
	private String foodName;
	private String foodCat;
	private double foodPrice;
	private int Vendor_idVendor;
	public food() {
		super();
		// TODO Auto-generated constructor stub
	}
	public food(int id, String foodName, String foodCat, double foodPrice, int vendor_idVendor) {
		super();
		this.id = id;
		this.foodName = foodName;
		this.foodCat = foodCat;
		this.foodPrice = foodPrice;
		Vendor_idVendor = vendor_idVendor;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public String getFoodCat() {
		return foodCat;
	}
	public void setFoodCat(String foodCat) {
		this.foodCat = foodCat;
	}
	public double getFoodPrice() {
		return foodPrice;
	}
	public void setFoodPrice(double foodPrice) {
		this.foodPrice = foodPrice;
	}
	public int getVendor_idVendor() {
		return Vendor_idVendor;
	}
	public void setVendor_idVendor(int vendor_idVendor) {
		Vendor_idVendor = vendor_idVendor;
	}
	@Override
	public String toString() {
		return "food [id=" + id + ", foodName=" + foodName + ", foodCat=" + foodCat + ", foodPrice=" + foodPrice
				+ ", Vendor_idVendor=" + Vendor_idVendor + "]";
	}
	
	
	

}
