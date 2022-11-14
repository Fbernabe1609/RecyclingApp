package com.example.practica_1_trimestre_multimedia.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.practica_1_trimestre_multimedia.R;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {

    Button enterButton, goBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Objects.requireNonNull(getSupportActionBar()).hide();
        goBackButton = (Button) findViewById(R.id.goBackMainLButton);
        goBackButton.setOnClickListener(view -> finish());
        enterButton = (Button) findViewById(R.id.enterLoginButton);
        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, HomeActivity.class));
            }
        });
//        DataBaseHelper dbHelper = new DataBaseHelper(LoginActivity.this);
//        SQLiteDatabase db = dbHelper.getWritableDatabase();
//        if (db != null) {
//            if (validation.isTextFilled((EditText)findViewById(R.id.editTextUsername)) && validation.isTextFilled((EditText)findViewById(R.id.editTextPassword))) {
//                if (dbHelper.checkUserLogin(((EditText)findViewById(R.id.editTextUsername)).getText().toString(), ((EditText)findViewById(R.id.editTextPassword)).getText().toString(), db)) {
//                    startActivity(new Intent(this, HomeActivity.class));
//                } else {
//                    Toast.makeText(MainActivity.this, "No hay ningún usario con esos datos.", Toast.LENGTH_LONG).show();
//                }
//            } else {
//
//                Toast.makeText(MainActivity.this, "Debe escribir en todos los campos.", Toast.LENGTH_LONG).show();
//            }
//        } else {
//            Toast.makeText(MainActivity.this, "Error: Base de datos no creada", Toast.LENGTH_LONG).show();
//        }
    }
}