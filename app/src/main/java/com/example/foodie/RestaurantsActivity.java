package com.example.foodie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class RestaurantsActivity extends AppCompatActivity {

    TextView welcomeTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);

        Intent i = getIntent();
        String username = i.getStringExtra("username");
        welcomeTextView = findViewById(R.id.welcomeText);
        welcomeTextView.setText(String.format("Welcome, %s", username));
    }
}