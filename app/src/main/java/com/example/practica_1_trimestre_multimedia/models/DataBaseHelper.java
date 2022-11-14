package com.example.practica_1_trimestre_multimedia.models;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "RecyclingApp.db";
    private final String TABLE_USER = "users";

    private final String COLUMN_ID = "id";
    private final String COLUMN_USERNAME = "username";
    private final String COLUMN_EMAIL = "email";
    private final String COLUMN_PASSWORD = "password";
    private final String COLUMN_POINTS = "points";

    private final String CREATE_TABLE = "CREATE TABLE " + TABLE_USER + "(" + COLUMN_ID +
            " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_USERNAME + " TEXT UNIQUE," + COLUMN_EMAIL +
            " TEXT UNIQUE," + COLUMN_PASSWORD + " TEXT," + COLUMN_POINTS + " TEXT" + ")";
    private final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER;

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public String getTABLE_USER() {
        return TABLE_USER;
    }

    public String getCOLUMN_ID() {
        return COLUMN_ID;
    }

    public String getCOLUMN_USERNAME() {
        return COLUMN_USERNAME;
    }

    public String getCOLUMN_EMAIL() {
        return COLUMN_EMAIL;
    }

    public String getCOLUMN_PASSWORD() {
        return COLUMN_PASSWORD;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DROP_TABLE);
        onCreate(sqLiteDatabase);
    }
}
