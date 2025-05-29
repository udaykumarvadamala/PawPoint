package com.example.pawpoint.database;

public final class DBContract {
    private DBContract() {}

    public static class UserTable {
        public static final String TABLE_NAME = "users";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_EMAIL = "email";
        public static final String COLUMN_PASSWORD = "password";
    }

    public static class AppointmentTable {
        public static final String TABLE_NAME = "appointments";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_USER_ID = "user_id";
        public static final String COLUMN_PET_TYPE = "pet_type";
        public static final String COLUMN_SERVICE_TYPE = "service_type";
        public static final String COLUMN_DATE = "date";
        public static final String COLUMN_TIME = "time";
    }
}
