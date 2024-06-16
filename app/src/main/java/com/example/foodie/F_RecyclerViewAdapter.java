package com.example.foodie;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class F_RecyclerViewAdapter extends RecyclerView.Adapter<F_RecyclerViewAdapter.MyViewHolder>{

    Context context;
    ArrayList<FoodModel> foodModelsList;
    String restaurantName;

    public F_RecyclerViewAdapter(Context context, ArrayList<FoodModel> foodModelsList, String restaurantName) {
        this.foodModelsList = foodModelsList;
        this.context = context;
        this.restaurantName = restaurantName;
    }

    @NonNull
    @Override
    public F_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.foods_recycler_view_row, parent, false);

        return new F_RecyclerViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull F_RecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.foodNameTextView.setText(foodModelsList.get(position).getName());
        holder.foodDescriptionTextView.setText(foodModelsList.get(position).getDescription());
        holder.priceTextView.setText(foodModelsList.get(position).getPrice());

        //button
        holder.addToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String foodName = String.valueOf(holder.foodNameTextView.getText());
                String restName = restaurantName;
                String price = String.valueOf(holder.priceTextView.getText());
                String item = foodName + " (" + restName + ") - " + price;
                Cart.addItem(item);
                //TODO: calculate the order price in addItem()
                //TODO: add "order" button
                Log.i("CartActivity", String.format("%s added to cart.", foodName));
            }
        });
        Picasso.get().load(foodModelsList.get(position).getImage()).fit().into(holder.foodImageView);
    }

    @Override
    public int getItemCount() {
        return foodModelsList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView foodNameTextView;
        TextView foodDescriptionTextView;
        TextView priceTextView;

        ImageView foodImageView;
        Button addToCartButton;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            foodNameTextView = itemView.findViewById(R.id.foodNameTextView);
            foodDescriptionTextView = itemView.findViewById(R.id.foodDescriptionTextView);
            priceTextView = itemView.findViewById(R.id.priceTextView);

            foodImageView = itemView.findViewById(R.id.foodImageView);
            addToCartButton = itemView.findViewById(R.id.addToCartButton);
        }
    }
}
