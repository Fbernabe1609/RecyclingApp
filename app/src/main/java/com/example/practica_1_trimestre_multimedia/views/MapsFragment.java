package com.example.practica_1_trimestre_multimedia.views;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.practica_1_trimestre_multimedia.R;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MapsFragment extends Fragment {

    List<String> randomSentences  = List.of(
            "Casa de Calamardo",
            "Roca de Patricio",
            "Piña de Bob Esponja",
            "Reunión de anchoas",
            "Un Tentacool salvaje ha aparecido",
            "Un Tentacruel salvaje ha aparecido",
            "Pingu y la foca",
            "Una aparición masiva de Vaporeon ha comenzado",
            "Krustacio Krujiente",
            "Submarino amarillo",
            "El One Pice",
            "Atlantida, C/El ahogado",
            "Casa de Acuaman",
            "Vaporeon quiere ser tu amigo",
            "Una aparición masiva de Magikarp ha comenzado",
            "Antonio quiero un 10",
            "Nave extraterrestre no identificada",
            "Grupo de sirenas tomento un café",
            "Sebastián y Ariel cantando 'Bajo el mar'"
            );

    private final OnMapReadyCallback callback = googleMap -> {
        LatLng granada = new LatLng(37.18817, -3.60667);
        googleMap.addMarker(new MarkerOptions()
                .position(granada)
                .title(text(granada))
                .draggable(true)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(granada));
        googleMap.setOnMapClickListener(latLng -> {
            googleMap.clear();
            googleMap.addMarker(new MarkerOptions()
                    .position(latLng).title(text(latLng))
                    .draggable(true)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)));
        });
    };


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_maps, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }

    public String text(LatLng latLng) {
        Geocoder geocoder = new Geocoder(getContext(), Locale.getDefault());
        List<Address> direction = null;
        try {
            direction = geocoder.getFromLocation(latLng.latitude, latLng.longitude, 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (direction != null && !direction.isEmpty()) ? direction.get(0).getAddressLine(0) : randomSentences.get((int)(Math.random() * randomSentences.size()));
    }
}