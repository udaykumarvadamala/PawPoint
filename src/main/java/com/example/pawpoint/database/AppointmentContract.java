package com.example.pawpoint.database;

import android.provider.BaseColumns;

public final class AppointmentContract {

    private AppointmentContract() {
    }

    public static class AppointmentEntry implements BaseColumns {
        public static final String TABLE_NAME = "appointments";
        public static final String COLUMN_PET_NAME = "pet_name";
        public static final String COLUMN_OWNER_NAME = "owner_name";
        public static final String COLUMN_CONTACT = "contact";
        public static final String COLUMN_DATE = "date";
        public static final String COLUMN_SERVICE_TYPE = "service_type";
    }

    public static final class UserContract {
        private UserContract() {
        }

        public static class UserEntry implements BaseColumns {
            public static final String TABLE_USERS = "users";
            public static final String COLUMN_ID = BaseColumns._ID; // "_id"
            public static final String COLUMN_EMAIL = "email";
            public static final String COLUMN_PASSWORD = "password";
        }
    }
}
