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
import android.widget.EditText;

import com.example.practica_1_trimestre_multimedia.R;
import com.example.practica_1_trimestre_multimedia.controllers.DataBaseController;
import com.example.practica_1_trimestre_multimedia.controllers.UserController;
import com.example.practica_1_trimestre_multimedia.controllers.ValidationData;

public class EditEmailFragment extends Fragment {

    public EditEmailFragment() {
    }

    View view;
    String editText;
    Button button;
    Activity activity;
    HomeInterface homeInterface;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_edit_email, container, false);
        SQLiteDatabase db = DataBaseController.getDataBase().getWritableDatabase();
        button = (Button) view.findViewById(R.id.changeButton);
        button.setOnClickListener(view2 -> {
            view2 = view;
            if (ValidationData.isTextEmail((EditText) view2.findViewById(R.id.editEmailField))) {
                editText = ((EditText) view2.findViewById(R.id.editEmailField)).getText().toString();
                int result = DataBaseController.updateUserEmail(db, editText);
                if (result != -1) {
                    UserController.updateUserEmail(editText);
                    homeInterface.completeEdit();
                } else {
                    homeInterface.errorEditPassword();
                }
            } else {
                homeInterface.errorEditEmail();
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