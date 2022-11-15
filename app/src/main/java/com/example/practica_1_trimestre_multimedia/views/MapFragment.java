package com.example.practica_1_trimestre_multimedia.views;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.practica_1_trimestre_multimedia.R;
import com.google.android.gms.maps.SupportMapFragment;

public class MapFragment extends Fragment {

    public MapFragment() {
    }

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_map, container, false);
        return view;
    }
}