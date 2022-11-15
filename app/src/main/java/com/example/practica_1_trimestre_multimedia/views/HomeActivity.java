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
    ProfileFragment profileFragment = new ProfileFragment();
    MapFragment mapFragment = new MapFragment();

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
                case R.id.map:
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, mapFragment).commit();
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
    public void errorDelete() {
        Toast.makeText(HomeActivity.this, "Error: no se ha podido eliminar al usuario.", Toast.LENGTH_LONG).show();
    }

    @Override
    public void lessThanZero() {
        Toast.makeText(HomeActivity.this, "No pueden bajar más tus puntos.", Toast.LENGTH_LONG).show();
    }

    @Override
    public void editPointsText() {
        points.setText("Puntos: " + UserController.getUser().getPoints());
    }

    @Override
    public void errorEditPoints() {
        Toast.makeText(HomeActivity.this, "Error: no pueden se han podido actualizar los puntos.", Toast.LENGTH_LONG).show();
    }

    @Override
    public void profileUser() {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, profileFragment).commit();
    }

    @Override
    public void errorEditPassword() {
        Toast.makeText(HomeActivity.this, "No se ha podido cambiar la contraseña.", Toast.LENGTH_LONG).show();
    }

    @Override
    public void errorEditEmail() {
        Toast.makeText(HomeActivity.this, "No se ha podido cambiar el email.", Toast.LENGTH_LONG).show();
    }
}

