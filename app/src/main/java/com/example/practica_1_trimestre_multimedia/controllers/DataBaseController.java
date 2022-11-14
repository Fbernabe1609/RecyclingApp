package com.example.practica_1_trimestre_multimedia.controllers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.practica_1_trimestre_multimedia.models.DataBaseHelper;
import com.example.practica_1_trimestre_multimedia.models.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseController {

    static DataBaseHelper dataBase;

    public static void startDataBase(Context context) {
        dataBase = new DataBaseHelper(context);
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

    public static boolean checkUserLogin(String username, String password, SQLiteDatabase db) {

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

    public static boolean checkEmail(String email, SQLiteDatabase db) {

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

    public static boolean checkUsername(String username, SQLiteDatabase db) {

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

    public static int checkUserRegister(String email, String username, SQLiteDatabase db) {

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

    public static DataBaseHelper getDataBase() {
        return dataBase;
    }

    public static String selectEmail(String username, SQLiteDatabase db) {
        String[] columns = {
                dataBase.getCOLUMN_EMAIL()
        };
        String[] selectionArgs = {
                username
        };
        String selection = dataBase.getCOLUMN_USERNAME() + " = ?";
        Cursor cursor = db.query(
                dataBase.getTABLE_USER(),
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null
        );
        cursor.moveToFirst();
        return cursor.getString(0);
    }

    public static int selectPoints(String username, SQLiteDatabase db) {
        String[] columns = {
                dataBase.getCOLUMN_POINTS()
        };
        String[] selectionArgs = {
                username
        };
        String selection = dataBase.getCOLUMN_USERNAME() + " = ?";
        Cursor cursor = db.query(
                dataBase.getTABLE_USER(),
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null
        );
        cursor.moveToFirst();
        return cursor.getInt(0);
    }

    public static void userLogin(String username, String password, SQLiteDatabase db) {
        UserController.createUserLogin(username,selectEmail(username,db),password);
    }

    public static int deleteUser(SQLiteDatabase db) {
        String[] columns = {
                dataBase.getCOLUMN_USERNAME()
        };
        String[] selectionArgs = {
                UserController.getUser().getUsername()
        };
        String selection = dataBase.getCOLUMN_USERNAME() + " = ?";
        return db.delete(
                dataBase.getTABLE_USER(),
                selection,
                selectionArgs
        );
    }
}
