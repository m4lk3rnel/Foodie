package com.example.foodie;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class F_RecyclerViewAdapter extends RecyclerView.Adapter<F_RecyclerViewAdapter.MyViewHolder>{

    Context context;
    ArrayList<FoodModel> foodModelsList;

    public F_RecyclerViewAdapter(Context context, ArrayList<FoodModel> foodModelsList) {
        this.foodModelsList = foodModelsList;
        this.context = context;
    }

    @NonNull
    @Override
    public F_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = new LayoutInflater(context) {
            @Override
            public LayoutInflater cloneInContext(Context newContext) {
                return null;
            }
        };

        inflater.inflate(R.layout.foods_recycler_view_row, parent);
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull F_RecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.foodNameTextView.setText(foodModelsList.get(position).getName());
        holder.foodDescriptionTextView.setText(foodModelsList.get(position).getDescription());
        //button
        Picasso.get().load(foodModelsList.get(position).getImage()).fit().into(holder.foodImageView);
    }

    @Override
    public int getItemCount() {
        return foodModelsList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView foodNameTextView;
        TextView foodDescriptionTextView;

        ImageView foodImageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            foodNameTextView = itemView.findViewById(R.id.foodNameTextView);
            foodDescriptionTextView = itemView.findViewById(R.id.foodDescriptionTextView);

            foodImageView = itemView.findViewById(R.id.foodImageView);

        }
    }
}
