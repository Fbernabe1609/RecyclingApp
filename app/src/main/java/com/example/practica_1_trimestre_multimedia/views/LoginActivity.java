package com.example.practica_1_trimestre_multimedia.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.practica_1_trimestre_multimedia.R;
import com.example.practica_1_trimestre_multimedia.controllers.DataBaseController;
import com.example.practica_1_trimestre_multimedia.controllers.UserController;
import com.example.practica_1_trimestre_multimedia.controllers.ValidationData;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {

    Button enterButton, goBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Objects.requireNonNull(getSupportActionBar()).hide();
        DataBaseController.startDataBase(LoginActivity.this);
        goBackButton = (Button) findViewById(R.id.goBackMainLButton);
        goBackButton.setOnClickListener(view -> finish());
        enterButton = (Button) findViewById(R.id.enterLoginButton);
        SQLiteDatabase db = DataBaseController.getDataBase().getWritableDatabase();
        enterButton.setOnClickListener(view -> {
            if (db != null) {
                if (ValidationData.isTextFilled((EditText)findViewById(R.id.usernameLField)) && ValidationData.isTextFilled((EditText)findViewById(R.id.passwordLField))) {
                    if (DataBaseController.checkUserLogin(((EditText)findViewById(R.id.usernameLField)).getText().toString(), ((EditText)findViewById(R.id.passwordLField)).getText().toString(), db)) {
                        DataBaseController.userLogin(((EditText)findViewById(R.id.usernameLField)).getText().toString(), ((EditText)findViewById(R.id.passwordLField)).getText().toString(), db);
                        UserController.getUser().setPoints(DataBaseController.selectPoints(((EditText)findViewById(R.id.usernameLField)).getText().toString(),db));
                        startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                        finish();
                    } else {
                        Toast.makeText(LoginActivity.this, "No hay ningún usario con esos datos.", Toast.LENGTH_LONG).show();
                    }
                } else {

                    Toast.makeText(LoginActivity.this, "Debe escribir en todos los campos.", Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(LoginActivity.this, "Error: Base de datos no creada", Toast.LENGTH_LONG).show();
            }
        });
    }
}