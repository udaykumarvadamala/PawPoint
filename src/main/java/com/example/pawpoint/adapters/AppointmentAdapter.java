package com.example.pawpoint.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pawpoint.R;
import com.example.pawpoint.models.Appointment;
import androidx.appcompat.app.AppCompatActivity;


import java.util.List;

public class AppointmentAdapter extends RecyclerView.Adapter<AppointmentAdapter.AppointmentViewHolder> {

    private List<Appointment> appointmentList;

    public AppointmentAdapter(List<Appointment> appointmentList) {
        this.appointmentList = appointmentList;
    }

    @NonNull
    @Override
    public AppointmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_appointment, parent, false);
        return new AppointmentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AppointmentViewHolder holder, int position) {
        Appointment appointment = appointmentList.get(position);
        holder.tvPetType.setText("Pet: " + appointment.getPetName());
        holder.tvServiceType.setText("Service: " + appointment.getServiceType());
        holder.tvDate.setText("Date: " + appointment.getDate());
    }

    @Override
    public int getItemCount() {
        return appointmentList.size();
    }

    public static class AppointmentViewHolder extends RecyclerView.ViewHolder {
        TextView tvPetType, tvServiceType, tvDate;

        public AppointmentViewHolder(@NonNull View itemView) {
            super(itemView);
            tvPetType = itemView.findViewById(R.id.tvPetType);
            tvServiceType = itemView.findViewById(R.id.tvServiceType);
            tvDate = itemView.findViewById(R.id.tvDate);
        }
    }
    public class BookingActivity extends AppCompatActivity {

        private Spinner spServiceType;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_book_appointment);  // Make sure this layout contains your Spinner

            // 1. Find the Spinner by ID
            spServiceType = findViewById(R.id.spServiceType);

            // 2. Create ArrayAdapter using the string-array and custom layout
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                    this,
                    R.array.service_types,
                    R.layout.spinner_item        // Custom layout for black text
            );

            // 3. Optional: customize dropdown layout
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            // 4. Set the adapter to the Spinner
            spServiceType.setAdapter(adapter);
        }
    }
}
