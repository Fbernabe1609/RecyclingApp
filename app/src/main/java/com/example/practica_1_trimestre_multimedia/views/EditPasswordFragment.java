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

public class EditPasswordFragment extends Fragment {

    public EditPasswordFragment() {
    }

    View view;
    String editText;
    Button button;
    Activity activity;
    HomeInterface homeInterface;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_edit_password, container, false);
        SQLiteDatabase db = DataBaseController.getDataBase().getWritableDatabase();
        button = (Button) view.findViewById(R.id.changeButton2);
        button.setOnClickListener(view2 -> {
            view2 = view;
            if (ValidationData.isTextFilled((EditText) view2.findViewById(R.id.editPasswordField2))) {
                editText = ((EditText) view2.findViewById(R.id.editPasswordField2)).getText().toString();
                int result = DataBaseController.updateUserPassword(db, editText);
                if (result != -1) {
                    UserController.updateUserPassword(editText);
                    homeInterface.completeEdit();
                } else {
                    homeInterface.errorEditPassword();
                }
            } else {
                homeInterface.completeFields();
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