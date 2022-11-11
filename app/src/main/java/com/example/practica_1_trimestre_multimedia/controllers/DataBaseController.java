package com.example.practica_1_trimestre_multimedia.controllers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.practica_1_trimestre_multimedia.models.DatabaseHelper;
import com.example.practica_1_trimestre_multimedia.models.User;

public class DataBaseController {

    static DatabaseHelper dataBase;

    public static void startDataBase(Context context) {
        DatabaseHelper db = new DatabaseHelper(context);
        dataBase = db;
    }

    public static boolean addUser(User user, SQLiteDatabase db) {

        boolean returned;

        ContentValues values = new ContentValues();
        values.put(dataBase.getCOLUMN_USERNAME(), user.getUsername());
        values.put(dataBase.getCOLUMN_EMAIL(), user.getEmail());
        values.put(dataBase.getCOLUMN_PASSWORD(), user.getPassword());
        long insert = db.insert(dataBase.getTABLE_USER(), null, values);
        if (insert == -1) {
            db.close();
            returned = false;
        } else {
            db.close();
            returned = true;
        }

        return returned;
    }

    public boolean checkUserLogin(String username, String password, SQLiteDatabase db) {

        boolean returned;

        String[] columns = {
                dataBase.getCOLUMN_ID()
        };
        String selection = dataBase.getCOLUMN_USERNAME() + " = ? AND " + dataBase.getCOLUMN_PASSWORD() + " = ?";
        String[] selectionArgs = {
                username,
                password
        };
        Cursor cursor = db.query(dataBase.getTABLE_USER(), columns, selection, selectionArgs, null,
                null, null);
        int cursorCount = cursor.getCount();
        cursor.close();
        if (cursorCount > 0) {
            returned = true;
        } else {
            returned = false;
        }
        return returned;
    }

    public boolean checkEmail(String email, SQLiteDatabase db) {

        boolean returned;

        String[] columns = {
                dataBase.getCOLUMN_ID()
        };
        String selection = dataBase.getCOLUMN_EMAIL() + " = ?";
        String[] selectionArgs = {
                email
        };
        Cursor cursor = db.query(dataBase.getTABLE_USER(), columns, selection, selectionArgs, null,
                null, null);
        int cursorCount = cursor.getCount();
        cursor.close();
        if (cursorCount > 0) {
            returned = true;
        } else {
            returned = false;
        }

        return returned;
    }

    public boolean checkUsername(String username, SQLiteDatabase db) {

        boolean returned;

        String[] columns = {
                dataBase.getCOLUMN_ID()
        };
        String selection = dataBase.getCOLUMN_USERNAME() + " = ?";
        String[] selectionArgs = {
                username
        };
        Cursor cursor = db.query(dataBase.getTABLE_USER(), columns, selection, selectionArgs, null,
                null, null);
        int cursorCount = cursor.getCount();
        cursor.close();
        if (cursorCount > 0) {
            returned = true;
        } else {
            returned = false;
        }

        return returned;
    }

    public int checkUserRegister(String email, String username, SQLiteDatabase db) {

        int returned;

        if (checkEmail(email, db) && checkUsername(username, db)) {
            //Ambos estan usados
            returned = 1;
        } else if (!checkEmail(email, db) && checkUsername(username, db)) {
            //Usuario ocupado
            returned = 2;
        } else if (checkEmail(email, db) && !checkUsername(username, db)) {
            //Correo ocupado
            returned = 3;
        } else {
            //Usuario creado
            returned = 0;
        }

        return returned;
    }
}
