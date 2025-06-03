package com.bean;

public class Cart {
	private int dishId;
	private String dishName;
	private int price;
	public Cart(int dishId, String dishName, int price, int quantity) {

		this.dishId = dishId;
		this.dishName = dishName;
		this.price = price;
		this.quantity = quantity;
	}
	private int quantity;
	
	public int getDishId() {
		return dishId;
	}
	public void setDishId(int dishId) {
		this.dishId = dishId;
	}
	public String getDishName() {
		return dishName;
	}
	public void setDishName(String dishName) {
		this.dishName = dishName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Cart() {
		// TODO Auto-generated constructor stub
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}
