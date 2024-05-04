package com.example.foodie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;


public class RegisterActivity extends AppCompatActivity {

    //TODO: make the activity look better
    Button btn;
    EditText usernameText;
    EditText passwordText;

    TextView alreadyAccText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btn = findViewById(R.id.sendButton);
        usernameText = findViewById(R.id.usernameText);
        passwordText = findViewById(R.id.passwordText);
        alreadyAccText = findViewById(R.id.alreadyAccText);

        RequestQueue queue = Volley.newRequestQueue(this);
        //String url = "http://10.0.2.2/foodie/add.php";
        String url = BuildConfig.BASE_URL + "/foodie/Register.php";

        btn.setOnClickListener(v -> {

            final String name = String.valueOf(usernameText.getText());
            final String password = String.valueOf(passwordText.getText());
            // Request a string response from the provided URL.
            StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                    response -> {
                        // Handle response

                        Log.d("Main Activity", response);
                    }, error -> {
                // Handle errors
                Log.e("Main Activity", error.toString());
            }) {
                @Override
                protected Map<String, String> getParams() {
                    Map<String, String> params = new HashMap<>();
                    params.put("username", name);
                    params.put("password", password);
                    return params;
                }
            };
            queue.add(stringRequest);
            System.out.println("Name: " + name);
            System.out.println("Password: " + password);
            System.out.println("url" + url);

            Intent i = new Intent(v.getContext(), RestaurantsActivity.class);
            i.putExtra("username", name);
            startActivity(i);

        });
        alreadyAccText.setOnClickListener(v -> {
            Intent i = new Intent(v.getContext(), LoginActivity.class);
            startActivity(i);
            Log.d("Register Activity", "Text view clicked");
        });
    }
}
