package com.example.practica_1_trimestre_multimedia.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.practica_1_trimestre_multimedia.R;
import com.example.practica_1_trimestre_multimedia.controllers.UserController;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Objects;

public class HomeActivity extends AppCompatActivity implements HomeInterface {

    BottomNavigationView bottomNavigationView;
    HomeFragment homeFragment = new HomeFragment();
    RewardsFragment rewardsFragment = new RewardsFragment();
    SettingsFragment settingsFragment = new SettingsFragment();

    TextView user, points;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Objects.requireNonNull(getSupportActionBar()).hide();
        user = (TextView) findViewById(R.id.textView4);
        user.setText(UserController.getUser().getUsername());
        points = (TextView) findViewById(R.id.textView5);
        String text = points.getText().toString();
        points.setText(text + " " + UserController.getUser().getPoints());
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment).commit();
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.home:
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();
                    return true;
                case R.id.rewards:
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, rewardsFragment).commit();
                    return true;
                case R.id.settings:
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, settingsFragment).commit();
                    return true;
            }
            return false;
        });
    }

    @Override
    public void finishFragment() {
        Toast.makeText(HomeActivity.this, "Se ha borrado el usuario.", Toast.LENGTH_LONG).show();
        finish();
    }

    @Override
    public void error() {
        Toast.makeText(HomeActivity.this, "Error: no se ha podido eliminar al usuario.", Toast.LENGTH_LONG).show();
    }
}

