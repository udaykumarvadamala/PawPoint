package com.example.pawpoint.activities;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pawpoint.R;
import com.example.pawpoint.adapters.AppointmentAdapter;
import com.example.pawpoint.database.DBHelper;
import com.example.pawpoint.models.Appointment;

import java.util.List;

public class ViewAppointmentsActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    AppointmentAdapter appointmentAdapter;
    DBHelper dbHelper;
    List<Appointment> appointmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_appointments);

        recyclerView = findViewById(R.id.recyclerViewAppointments);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        dbHelper = new DBHelper(this);

        // Fetch appointments from DB
        appointmentList = dbHelper.getAllAppointments();

        if (appointmentList.isEmpty()) {
            Toast.makeText(this, "No appointments found", Toast.LENGTH_SHORT).show();
        }

        appointmentAdapter = new AppointmentAdapter(appointmentList);
        recyclerView.setAdapter(appointmentAdapter);
    }
}
