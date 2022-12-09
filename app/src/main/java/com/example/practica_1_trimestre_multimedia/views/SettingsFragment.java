package com.example.practica_1_trimestre_multimedia.views;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.practica_1_trimestre_multimedia.R;
import com.example.practica_1_trimestre_multimedia.controllers.DataBaseController;

public class SettingsFragment extends Fragment {

    public SettingsFragment() {
    }

    View view;
    Button delete, editPassword, editEmail, showData;
    Activity activity;
    HomeInterface homeInterface;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_settings, container, false);
        SQLiteDatabase db = DataBaseController.getDataBase().getWritableDatabase();
        delete = (Button) view.findViewById(R.id.deleteAccountButton);
        editEmail = (Button) view.findViewById(R.id.changeEmailButton);
        editPassword = (Button) view.findViewById(R.id.changePasswordButton);
        showData = (Button) view.findViewById(R.id.showButton);
        showData.setOnClickListener(view -> homeInterface.profileUser());
        editEmail.setOnClickListener(view -> homeInterface.editEmail());
        editPassword.setOnClickListener(view -> homeInterface.editPassword());
        delete.setOnClickListener(view -> {
            if (DataBaseController.deleteUser(db) != -1) {
                homeInterface.finishFragment();
            } else {
                homeInterface.errorDelete();
            }
        });
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