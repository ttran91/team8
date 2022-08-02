package com.springboot.backend.dto;

import java.time.LocalDate;

public class InventoryDto {

	private int amountOfProductsInStock;
	private String outOfProductsStockExp;
	private int maxProductStock;
	private LocalDate dateAddedProduct;

	public int getAmountOfProductsInStock() {
		return amountOfProductsInStock;
	}

	public void setAmountOfProductsInStock(int amountOfProductsInStock) {
		this.amountOfProductsInStock = amountOfProductsInStock;
	}

	public String getOutOfProductsStockExp() {
		return outOfProductsStockExp;
	}

	public void setOutOfProductsStockExp(String outOfProductsStockExp) {
		this.outOfProductsStockExp = outOfProductsStockExp;
	}

	public int getMaxProductStock() {
		return maxProductStock;
	}

	public void setMaxProductStock(int maxProductStock) {
		this.maxProductStock = maxProductStock;
	}

	public LocalDate getDateAddedProduct() {
		return dateAddedProduct;
	}

	public void setDateAddedProduct(LocalDate dateAddedProduct) {
		this.dateAddedProduct = dateAddedProduct;
	}

}
