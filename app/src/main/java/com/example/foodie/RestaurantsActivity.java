package com.example.foodie;

import static com.example.foodie.RestaurantImages.restaurantImages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class RestaurantsActivity extends AppCompatActivity {

    TextView welcomeTextView;

    ArrayList<RestaurantModel> restaurantModels = new ArrayList<>();
    ArrayList<RestaurantModel> filteredRestaurantModels = new ArrayList<>();
    SearchView searchView;
    RecyclerView restRecyclerView;

    public R_RecyclerViewAdapter recViewAdapter;

    ListView restListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);

        String username = getIntent().getStringExtra("username");
        welcomeTextView = findViewById(R.id.welcomeText);
        welcomeTextView.setText(String.format("Welcome, %s", username));

        searchView = findViewById(R.id.restaurantSearchView);
        restRecyclerView = findViewById(R.id.restRecyclerView);

        setUpRestaurantModels();

        recViewAdapter = new R_RecyclerViewAdapter(this, restaurantModels);

        restRecyclerView.setAdapter(recViewAdapter);
        restRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Log.d("RestaurantsActivity", "New search query text: " + newText);

                filterList(newText);

                return false;
            }
        });
    }
    private void setUpRestaurantModels() {
        String[] restaurantNames = getResources().getStringArray(R.array.restaurants_names);
        String[] descriptions = getResources().getStringArray(R.array.restaurants_descriptions);

        for(int i = 0; i < restaurantNames.length; i++ ) {
            restaurantModels.add(new RestaurantModel(restaurantNames[i], descriptions[i], restaurantImages[i]));
        }
    }

    private void filterList(String newText) {
        filteredRestaurantModels.clear();
        for(int i = 0; i < restaurantModels.size(); i++)
        {
            if(restaurantModels.get(i).getName().toLowerCase().contains(newText.toLowerCase()))
            {
                filteredRestaurantModels.add(restaurantModels.get(i));
            }
        }

        for(int i = 0; i < filteredRestaurantModels.size(); i++)
        {
            Log.d("RestaurantsActivity", filteredRestaurantModels.get(i).getName());
        }

        recViewAdapter.setRestaurantModels(filteredRestaurantModels);
    }
}