package com.example.mycarapplication.cars;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mycarapplication.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MyCarFragment extends Fragment {

private CarViewModel carViewModel;
    private RecyclerView recyclerView;
    private CarAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mycar, container, false);


        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.hasFixedSize();
        adapter = new CarAdapter();
        recyclerView.setAdapter(adapter);
        carViewModel = new ViewModelProvider(this).get(CarViewModel.class);

        carViewModel.getAllCars().observe(getViewLifecycleOwner(), adapter::updateData);

        FloatingActionButton floatingActionButton = view.findViewById(R.id.floatingButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), AddCarActivity.class);
                startActivity(intent);
            }

        });
        return view;


    }


}
