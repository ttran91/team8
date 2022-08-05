package com.springboot.backend.GP.dto;

public class FoodDto {
	private Long id;
	private String name;
	private Double foodPrice;
	private String foodCategory;
	private Long vid;
	private String vname;
	private String vphoneNumber;
	private String vemail;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getFoodPrice() {
		return foodPrice;
	}
	public void setFoodPrice(Double foodPrice) {
		this.foodPrice = foodPrice;
	}
	public String getFoodCategory() {
		return foodCategory;
	}
	public void setFoodCategory(String foodCategory) {
		this.foodCategory = foodCategory;
	}
	public Long getVid() {
		return vid;
	}
	public void setVid(Long vid) {
		this.vid = vid;
	}
	public String getVname() {
		return vname;
	}
	public void setVname(String vname) {
		this.vname = vname;
	}
	public String getVphoneNumber() {
		return vphoneNumber;
	}
	public void setVphoneNumber(String vphoneNumber) {
		this.vphoneNumber = vphoneNumber;
	}
	public String getVemail() {
		return vemail;
	}
	public void setVemail(String vemail) {
		this.vemail = vemail;
	}

}
