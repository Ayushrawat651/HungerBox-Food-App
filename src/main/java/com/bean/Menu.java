package com.bean;

public class Menu {
    private int menuId;
    private String dishName;
    private String dishDescription;
    private boolean veg;
    private String imgUrl;
    private int price;
    private int quantity;
    private boolean status;

    // Constructor
    public Menu(int menuId, String dishName, String dishDescription,boolean veg,String imgUrl, int price, int quantity, boolean status) {
        this.menuId = menuId;
        this.dishName = dishName;
        this.dishDescription = dishDescription;
        this.veg = veg;
        this.imgUrl = imgUrl;
        this.price = price;
        this.quantity = quantity;
        this.status = status;
    }

    public Menu() {
		// TODO Auto-generated constructor stub
	}

	// Getters
    public int getMenuId() {
        return menuId;
    }

    public String getDishName() {
        return dishName;
    }

    public String getDishDescription() {
        return dishDescription;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean getStatus() {
        return status;
    }

    public boolean getVeg() {
                return veg;
        }

        public String getImgUrl() {
                return imgUrl;
        }

    // Setters
    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public void setDishDescription(String dishDescription) {
        this.dishDescription = dishDescription;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


        public void setVeg(boolean veg) {
                this.veg = veg;
        }

        public void setImgUrl(String imgUrl) {
                this.imgUrl = imgUrl;
        }
}