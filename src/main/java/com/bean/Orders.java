package com.bean;

import java.util.HashMap;

public class Orders {
    private int orderId;
    private int customerId;
    private String dishes;
    private int status;

    // Constructor
    public Orders(int orderId, int customerId, String dishes, int status) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.dishes = dishes;
        this.status = status;
    }

    public Orders() {
		// TODO Auto-generated constructor stub
	}

	// Getters
    public int getOrderId() {
        return orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getDishes() {
        return dishes;
    }
    
    public HashMap<String,Integer> getArrayDishes() {
    	 HashMap<String, Integer> map = new HashMap<>();
    	String[] entries = this.dishes.split(", ");
        for (String entry : entries) {
            String[] keyValue = entry.split(" X");
            if (keyValue.length == 2) {
                String key = keyValue[0];
                Integer value = Integer.parseInt(keyValue[1]);
                map.put(key, value);
            }
        }
        return map;
    }

    public int getStatus() {
        return status;
    }

    // Setters
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setDishes(HashMap<String,Integer> dishes) {
        this.dishes = dishes.entrySet()
                .stream()
                .map(entry -> entry.getKey() + " X" + entry.getValue())
                .reduce((s1, s2) -> s1 + ", " + s2)
                .orElse("");
    }

    public void setStatus(int status) {
        this.status = status;
    }
}