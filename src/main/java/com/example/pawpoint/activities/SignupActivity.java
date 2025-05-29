package com.example.pawpoint.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.pawpoint.database.DBHelper;


import androidx.appcompat.app.AppCompatActivity;

import com.example.pawpoint.R; // ✅ Fix package name here
import com.example.pawpoint.database.DBHelper; // ✅ Fix DBHelper import if needed

public class SignupActivity extends AppCompatActivity {

    private EditText etEmail, etPassword;
    private Button btnSignup;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnSignup = findViewById(R.id.btnSignup);
        dbHelper = new DBHelper(this);

        btnSignup.setOnClickListener(v -> {
            String email = etEmail.getText().toString().trim();
            String password = etPassword.getText().toString().trim();

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(SignupActivity.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
            } else {
                boolean success = dbHelper.insertUser(email, password);
                if (success) {
                    Toast.makeText(SignupActivity.this, "Signup successful!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(SignupActivity.this, LoginActivity.class));
                    finish();
                } else {
                    Toast.makeText(SignupActivity.this, "Signup failed. Try again.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
