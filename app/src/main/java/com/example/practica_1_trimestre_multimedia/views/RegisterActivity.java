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

public class RegisterActivity extends AppCompatActivity {

    Button enterButton, goBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Objects.requireNonNull(getSupportActionBar()).hide();
        DataBaseController.startDataBase(RegisterActivity.this);
        goBackButton = (Button) findViewById(R.id.goBackMainRButton);
        goBackButton.setOnClickListener(view -> finish());
        enterButton = (Button) findViewById(R.id.enterRegisterButton);
        enterButton.setOnClickListener(view -> {
            SQLiteDatabase db = DataBaseController.getDataBase().getWritableDatabase();

            if (db != null) {
                if (ValidationData.isTextFilled((EditText) findViewById(R.id.usernameRField)) && ValidationData.isTextEmail((EditText) findViewById(R.id.emailField)) && ValidationData.isTextFilled((EditText) findViewById(R.id.passwordRField)) && ValidationData.isTextFilled((EditText) findViewById(R.id.confirmPasswordField))) {
                    if (ValidationData.isMatchesPasswords((EditText) findViewById(R.id.passwordRField), (EditText) findViewById(R.id.confirmPasswordField))) {
                        switch (DataBaseController.checkUserRegister(((EditText) findViewById(R.id.emailField)).getText().toString(), ((EditText) findViewById(R.id.usernameRField)).getText().toString(), db)) {

                            case 1:
                                Toast.makeText(RegisterActivity.this, "Ya existe un usuario con ese correo y nombre.", Toast.LENGTH_LONG).show();
                                break;

                            case 2:
                                Toast.makeText(RegisterActivity.this, "Ya existe un usuario con ese  nombre.", Toast.LENGTH_LONG).show();
                                break;

                            case 3:
                                Toast.makeText(RegisterActivity.this, "Ya existe un usuario con ese correo.", Toast.LENGTH_LONG).show();
                                break;

                            default:
                                UserController.createUser(((EditText) findViewById(R.id.usernameRField)).getText().toString(), ((EditText) findViewById(R.id.emailField)).getText().toString(), ((EditText) findViewById(R.id.passwordRField)).getText().toString());
                                boolean created = DataBaseController.addUser(UserController.getUser(), db);

                                if (created) {

                                    Toast.makeText(RegisterActivity.this, "Usuario creado exitosamente.", Toast.LENGTH_LONG).show();
                                    startActivity(new Intent(RegisterActivity.this, HomeActivity.class));
                                    finish();
                                } else {

                                    Toast.makeText(RegisterActivity.this, "No se ha podido crear el usuario.", Toast.LENGTH_LONG).show();
                                }
                                break;
                        }
                    } else {
                        Toast.makeText(RegisterActivity.this, "La contraseña no coincide con su confirmación.", Toast.LENGTH_LONG).show();
                    }
                } else {

                    Toast.makeText(RegisterActivity.this, "Debe escribir en todos los campos.", Toast.LENGTH_LONG).show();
                }
            } else {

                Toast.makeText(RegisterActivity.this, "Error: Base de datos no creada", Toast.LENGTH_LONG).show();
            }
        });
    }
}