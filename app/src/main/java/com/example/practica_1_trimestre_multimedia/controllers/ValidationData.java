package com.example.practica_1_trimestre_multimedia.controllers;

import android.content.Context;
import android.widget.EditText;

public class ValidationData {

    private Context context;

    public ValidationData(Context context) {
        this.context = context;
    }

    public boolean isTextFilled(EditText textInputEditText) {
        String value = textInputEditText.getText().toString().trim();
        if (value.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isTextEmail(EditText textInputEditText) {
        String value = textInputEditText.getText().toString().trim();
        if (value.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(value).matches()) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isMatchesPasswords(EditText textInputEditText1, EditText textInputEditText2) {
        String value1 = textInputEditText1.getText().toString().trim();
        String value2 = textInputEditText2.getText().toString().trim();
        if (!value1.contentEquals(value2)) {
            return false;
        } else {
            return true;
        }
    }
}
