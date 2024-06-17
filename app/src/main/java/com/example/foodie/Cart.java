package com.example.foodie;

import java.util.ArrayList;

public class Cart {
    private static final ArrayList<String> items = new ArrayList<>();
    private static float total = 0.0f;

    public static void addItem(String item, float price) {
        items.add(item);
        total += price;
    }

    public static String getTotal() {
        return String.format("Total: %.2f$", total);
    }

    public static ArrayList<String> getItems() {
        return items;
    }
}
