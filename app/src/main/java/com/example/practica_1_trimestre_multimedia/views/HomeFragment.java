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
import com.example.practica_1_trimestre_multimedia.controllers.UserController;

public class HomeFragment extends Fragment {
    public HomeFragment() {
    }

    View view;
    Button addPoints, subtractPoints;
    Activity activity;
    HomeInterface homeInterface;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        SQLiteDatabase db = DataBaseController.getDataBase().getWritableDatabase();
        addPoints = view.findViewById(R.id.recycleButton);
        subtractPoints = view.findViewById(R.id.deleteRecycleButton);
        addPoints.setOnClickListener(view -> {
            UserController.editUserPoints(10);
            if (DataBaseController.updateUserPoints(db) != -1) {
                homeInterface.editPointsText();
            } else {
                UserController.editUserPoints(-10);
                homeInterface.errorEditPoints();
            }
        });
        subtractPoints.setOnClickListener(view -> {
            if (UserController.getUser().getPoints() > 0) {
                UserController.editUserPoints(-10);
                if (DataBaseController.updateUserPoints(db) != -1) {
                    homeInterface.editPointsText();
                } else {
                    UserController.editUserPoints(10);
                    homeInterface.errorEditPoints();
                }
            } else {
                homeInterface.lessThanZero();
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