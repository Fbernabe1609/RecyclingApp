package com.example.practica_1_trimestre_multimedia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.practica_1_trimestre_multimedia.views.LoginActivity;
import com.example.practica_1_trimestre_multimedia.views.RegisterActivity;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    Button login, register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).hide();
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        login = (Button) findViewById(R.id.loginButton);
        login.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, LoginActivity.class)));
        register = (Button) findViewById(R.id.registerButton);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
            }
        });
    }
}