package com.example.foodie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    //TODO: login php

    TextView newAccountText;
    //TODO: make the activity look better
    Button btn;
    EditText usernameText;
    EditText passwordText;

    TextView alreadyAccText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn = findViewById(R.id.sendButton);
        usernameText = findViewById(R.id.usernameText);
        passwordText = findViewById(R.id.passwordText);

        newAccountText = findViewById(R.id.noAccText);

        newAccountText.setOnClickListener(v -> {
            Intent i = new Intent(v.getContext(), RegisterActivity.class);
            startActivity(i);
            Log.d("Login Activity", "Text view clicked");
        });
    }
}