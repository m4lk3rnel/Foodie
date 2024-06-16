package com.example.foodie;

import java.util.ArrayList;

public class Cart {
    private static ArrayList<String> items = new ArrayList<>();

    public static void addItem(String item) {
        items.add(item);
    }

    public static ArrayList<String> getItems() {
        return items;
    }
}
