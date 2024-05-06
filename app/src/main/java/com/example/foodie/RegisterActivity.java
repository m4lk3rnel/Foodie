package com.example.foodie;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.JsonReader;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class RegisterActivity extends AppCompatActivity {

    //TODO: make the activity look better
    Button btn;
    EditText usernameText;
    EditText passwordText;

    TextView alreadyAccText;

    SearchView searchView;


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
        System.out.println("test");
        Log.i("Register", "test");
        Log.i("main", "test");
        btn.setOnClickListener(v -> {

            final String name = String.valueOf(usernameText.getText());
            final String password = String.valueOf(passwordText.getText());
            // Request a string response from the provided URL.
            Log.d("Register", String.format("Username: %s\nPassword: %s", name, password));
            StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                    response -> {
                        // Handle response

                        Log.d("Register", "Response: " + response);
                        System.out.println("Response: " + response);
                        try {
                            JSONObject json = new JSONObject(response);
                            String responseValue = json.getString("response");
                            switch(responseValue)
                            {
                                case "Success": {
                                    Intent i = new Intent(v.getContext(), RestaurantsActivity.class);
                                    i.putExtra("username", name);
                                    startActivity(i);
                                    Log.d("Register", "Success");
                                    break;
                                }
                                case "Exists": {
                                    Log.d("Register", "Already exists");
                                    Toast.makeText(v.getContext(), "Username already exists!", Toast.LENGTH_SHORT).show();

                                    break;
                                }
                                default: {
                                    Toast.makeText(v.getContext(), "An error occurred.", Toast.LENGTH_SHORT).show();

                                    break;
                                }
                            }

                        } catch (Exception e) {
                            Log.e("Register", String.format("%s: %s", e, e.getMessage()));
                        }
                    }, error -> {
                // Handle errors
                Log.e("Register", String.format("%s: %s", error, error.getMessage()));
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



        });
        alreadyAccText.setOnClickListener(v -> {
            Intent i = new Intent(v.getContext(), LoginActivity.class);
            startActivity(i);
            Log.d("Register", "Text view clicked");
        });

    }
}
