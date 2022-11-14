package com.example.practica_1_trimestre_multimedia.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.practica_1_trimestre_multimedia.R;

import java.util.Objects;

public class RegisterActivity extends AppCompatActivity {

    Button enterButton, goBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Objects.requireNonNull(getSupportActionBar()).hide();
        goBackButton = (Button) findViewById(R.id.goBackMainRButton);
        goBackButton.setOnClickListener(view -> finish());
    }
}