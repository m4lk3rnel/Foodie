package com.example.foodie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    ListView cartItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        ArrayList<String> items = Cart.getItems();
        cartItems = findViewById(R.id.cartItemsListView);

        cartItems.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items));



    }
}