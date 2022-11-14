package com.example.practica_1_trimestre_multimedia.views;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.practica_1_trimestre_multimedia.R;

public class SettingsFragment extends Fragment {

    public SettingsFragment() {
    }

    View view;
    Button delete;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_settings, container, false);

        delete = view.findViewById(R.id.deleteAccountButton);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        return view;
    }
}