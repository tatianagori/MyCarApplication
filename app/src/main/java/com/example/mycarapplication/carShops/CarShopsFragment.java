package com.example.mycarapplication.carShops;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mycarapplication.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class CarShopsFragment extends Fragment {

    private OnMapReadyCallback callback = new OnMapReadyCallback() {
    @Override
    public void onMapReady(GoogleMap googleMap) {
        // Adding markers for carshops
        LatLng fixMyCar = new LatLng(55.8594764, 9.8624380);
        LatLng qbauto = new LatLng(55.8699154, 9.8464972);
        LatLng mbService = new LatLng(55.8703366, 9.8405194);
        LatLng carPeople = new LatLng(55.8504011, 9.8462626);
        googleMap.addMarker(new MarkerOptions().position(fixMyCar).title("Marker in fixMyCar"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(fixMyCar));
        googleMap.addMarker(new MarkerOptions().position(qbauto).title("Marker in qbautoCar"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(qbauto));
        googleMap.addMarker(new MarkerOptions().position(mbService).title("Marker in mbService"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(mbService));
        googleMap.addMarker(new MarkerOptions().position(carPeople).title("Marker in carPeople"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(carPeople));

    }
};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_carshops,container, false);



    }


    }

