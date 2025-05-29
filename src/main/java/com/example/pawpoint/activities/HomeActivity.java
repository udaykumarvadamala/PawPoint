package com.example.pawpoint.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast; // <-- Import Toast

import androidx.appcompat.app.AppCompatActivity;

import com.example.pawpoint.R;

public class HomeActivity extends AppCompatActivity {

    Button btnBookAppointment, btnViewAppointments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnBookAppointment = findViewById(R.id.btnBookAppointment);
        btnViewAppointments = findViewById(R.id.btnViewAppointments);

        btnBookAppointment.setOnClickListener(v -> {
            Toast.makeText(HomeActivity.this, "Navigating to Book Appointment", Toast.LENGTH_SHORT).show(); // ✅ Toast
            Intent intent = new Intent(HomeActivity.this, BookAppointmentActivity.class);
            startActivity(intent);
        });

        btnViewAppointments.setOnClickListener(v -> {
            Toast.makeText(HomeActivity.this, "Viewing Appointments", Toast.LENGTH_SHORT).show(); // ✅ Toast
            Intent intent = new Intent(HomeActivity.this, ViewAppointmentsActivity.class);
            startActivity(intent);
        });
    }
}
