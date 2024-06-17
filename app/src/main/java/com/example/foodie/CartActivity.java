package com.example.foodie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CartActivity extends AppCompatActivity {

    ListView cartItems;
    TextView total;

    Button orderButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        cartItems = findViewById(R.id.cartItemsListView);
        total = findViewById(R.id.totalTextView);
        orderButton = findViewById(R.id.orderButton);

        ArrayList<String> items = Cart.getItems();

        cartItems.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items));

        total.setText(Cart.getTotal());

        orderButton.setOnClickListener(new OrderButtonClick());

    }

    public static class OrderButtonClick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < Cart.getItems().size(); i++)
            {
                sb.append(Cart.getItems().get(i));
                //TODO!!!
            }
//            final String name = String.valueOf(usernameText.getText());
//            final String password = String.valueOf(passwordText.getText());
            // Request a string response from the provided URL.

        }
    }
}