package com.example.foodie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class RestaurantActivity extends AppCompatActivity {

    TextView nameTextView;
    TextView descriptionTextView;

    ImageView restaurantImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);

        //trying to manipulate views BEFORE setting the content view of the activity WILL NOT WORK
        Log.d("Restaurant", "onCreate");
        String restaurantName = getIntent().getStringExtra("name");
        String restaurantDescription = getIntent().getStringExtra("description");
        int restaurantImagePosition = getIntent().getIntExtra("restaurant_image_id", 0);

        Log.d("Restaurant", String.format("name: %s, description: %s", restaurantName, restaurantDescription));
        nameTextView = findViewById(R.id.nameTextView);
        descriptionTextView = findViewById(R.id.descriptionTextView);
        restaurantImage = findViewById(R.id.restaurant_image);
        Picasso.get().load(RestaurantImages.restaurantImages[restaurantImagePosition]).fit().into(restaurantImage);

        nameTextView.setText(restaurantName);
        descriptionTextView.setText(restaurantDescription);

    }
}