package com.example.foodie;

public class FoodModel {
    String name;
    String description;

    String price;

    int image;

    public FoodModel(String name, String description, String price, int image) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getImage() {
        return image;
    }

    public String getPrice() { return price; }
}
