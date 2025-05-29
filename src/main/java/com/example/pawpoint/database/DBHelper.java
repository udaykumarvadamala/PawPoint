package com.example.pawpoint.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.pawpoint.models.Appointment;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "PawPoint.db";
    private static final int DATABASE_VERSION = 2;

    private static final String TABLE_USERS = "users";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_PASSWORD = "password";

    private static final String TABLE_APPOINTMENTS = "appointments";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createUsersTable = "CREATE TABLE users (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "email TEXT UNIQUE," +
                "password TEXT)";
        db.execSQL(createUsersTable);

        String createAppointmentsTable = "CREATE TABLE appointments (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "pet_name TEXT," +
                "owner_name TEXT," +
                "contact TEXT," +
                "date TEXT," +
                "service_type TEXT)";
        db.execSQL(createAppointmentsTable);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_APPOINTMENTS);
        onCreate(db);
    }

    // Insert new user
    public boolean insertUser(String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_EMAIL, email);
        contentValues.put(COLUMN_PASSWORD, password);

        long result = db.insert(TABLE_USERS, null, contentValues);
        db.close();

        return result != -1;

    }

    // Insert new appointment
    public boolean insertAppointment(String petName, String ownerName, String contact, String date, String serviceType) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("pet_name", petName);
        values.put("owner_name", ownerName);
        values.put("contact", contact);
        values.put("date", date);
        values.put("service_type", serviceType);

        long result = db.insert(TABLE_APPOINTMENTS, null, values);
        db.close();
        return result != -1;
    }

    // Get all appointments
    public List<Appointment> getAllAppointments() {
        List<Appointment> appointments = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_APPOINTMENTS, null);

        if (cursor.moveToFirst()) {
            do {
                Appointment appointment = new Appointment(
                        cursor.getString(cursor.getColumnIndexOrThrow("pet_name")),
                        cursor.getString(cursor.getColumnIndexOrThrow("owner_name")),
                        cursor.getString(cursor.getColumnIndexOrThrow("contact")),
                        cursor.getString(cursor.getColumnIndexOrThrow("date")),
                        cursor.getString(cursor.getColumnIndexOrThrow("service_type"))
                );
                appointments.add(appointment);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return appointments;
    }

}
