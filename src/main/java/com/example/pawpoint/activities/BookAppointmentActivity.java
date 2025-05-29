package com.example.pawpoint.activities;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pawpoint.R;
import com.example.pawpoint.database.DBHelper;

public class BookAppointmentActivity extends AppCompatActivity {

    EditText etPetName, etOwnerName, etContactNumber, etDate;
    Spinner spServiceType;
    Button btnBook;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_appointment);

        etPetName = findViewById(R.id.etPetName);
        etOwnerName = findViewById(R.id.etOwnerName);
        etContactNumber = findViewById(R.id.etContactNumber);
        etDate = findViewById(R.id.etDate);
        spServiceType = findViewById(R.id.spServiceType);
        btnBook = findViewById(R.id.btnBook);

        dbHelper = new DBHelper(this);

        // Set up spinner with service options
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.service_types, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spServiceType.setAdapter(adapter);

        btnBook.setOnClickListener(v -> {
            String petName = etPetName.getText().toString().trim();
            String ownerName = etOwnerName.getText().toString().trim();
            String contact = etContactNumber.getText().toString().trim();
            String date = etDate.getText().toString().trim();
            String serviceType = spServiceType.getSelectedItem().toString();

            // Validate inputs
            if (petName.isEmpty()) {
                Toast.makeText(this, "Please enter your pet's name", Toast.LENGTH_SHORT).show();
                return;
            }

            if (ownerName.isEmpty()) {
                Toast.makeText(this, "Please enter owner's name", Toast.LENGTH_SHORT).show();
                return;
            }

            if (contact.isEmpty()) {
                Toast.makeText(this, "Please enter contact number", Toast.LENGTH_SHORT).show();
                return;
            }

            if (date.isEmpty()) {
                Toast.makeText(this, "Please enter appointment date", Toast.LENGTH_SHORT).show();
                return;
            }

            // Attempt to insert appointment into database
            boolean inserted = dbHelper.insertAppointment(petName, ownerName, contact, date, serviceType);
            if (inserted) {
                Toast.makeText(this, "✅ Appointment booked successfully!", Toast.LENGTH_LONG).show();
                finish(); // Close activity and return
            } else {
                Toast.makeText(this, "❌ Failed to book appointment. Please try again.", Toast.LENGTH_LONG).show();
            }
        });
    }
}
