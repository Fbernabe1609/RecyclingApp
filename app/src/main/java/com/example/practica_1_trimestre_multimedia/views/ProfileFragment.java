package com.example.practica_1_trimestre_multimedia.views;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.practica_1_trimestre_multimedia.R;
import com.example.practica_1_trimestre_multimedia.controllers.UserController;

public class ProfileFragment extends Fragment {

    public ProfileFragment() {
    }

    View view;
    Activity activity;
    TextView email, password;
    HomeInterface homeInterface;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_profile, container, false);
        email = (TextView) view.findViewById(R.id.emailTextView);
        email.setText("Email: " + UserController.getUser().getEmail());
        password = (TextView) view.findViewById(R.id.passwordTextView);
        password.setText("Contraseña: " + UserController.getUser().getPassword());
        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof Activity) {
            activity = (Activity) context;
            homeInterface = (HomeInterface) activity;
        }
    }
}