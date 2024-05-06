package com.example.foodie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class RestaurantsActivity extends AppCompatActivity {

    TextView welcomeTextView;

    ArrayList<RestaurantModel> restaurantModels = new ArrayList<>();

    RecyclerView restRecyclerView;
    int[] restaurantImages = {R.drawable.restaurant1, R.drawable.restaurant2, R.drawable.restaurant3,
            R.drawable.restaurant1, R.drawable.restaurant2, R.drawable.restaurant3,
            R.drawable.restaurant1, R.drawable.restaurant2, R.drawable.restaurant3,
            R.drawable.restaurant1, R.drawable.restaurant2, R.drawable.restaurant3,
            R.drawable.restaurant1, R.drawable.restaurant2, R.drawable.restaurant3,
            R.drawable.restaurant1, R.drawable.restaurant2, R.drawable.restaurant3,
            R.drawable.restaurant1, R.drawable.restaurant2, R.drawable.restaurant3};
    ListView restListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);

        String username = getIntent().getStringExtra("username");
        welcomeTextView = findViewById(R.id.welcomeText);
        welcomeTextView.setText(String.format("Welcome, %s", username));

        restRecyclerView = findViewById(R.id.restRecyclerView);

        setUpRestaurantModels();

        restRecyclerView.setAdapter(new R_RecyclerViewAdapter(this, restaurantModels));
        restRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setUpRestaurantModels() {
        String[] restaurantNames = getResources().getStringArray(R.array.restaurants);
        String[] descriptions = getResources().getStringArray(R.array.descriptions);

        for(int i = 0; i < restaurantNames.length; i++ ) {
            restaurantModels.add(new RestaurantModel(restaurantNames[i], descriptions[i], restaurantImages[i]));
        }
    }
}