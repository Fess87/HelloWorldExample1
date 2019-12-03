package com.example.example511;

public class Product {

    private int price;
    private int quantity;
    private String name;
    private String image;
    private boolean checkbox;
    private String description;

    public Product(int price, int quantity, String name, String image, boolean checkbox, String description) {
        this.price = price;
        this.quantity = quantity;
        this.name = name;
        this.image = image;
        this.checkbox = checkbox;
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public boolean isCheckbox() {
        return checkbox;
    }

    public String getDescription() {
        return description;
    }

    public void setChecked(boolean checked) {
        this.checkbox = checked;
    }
}
