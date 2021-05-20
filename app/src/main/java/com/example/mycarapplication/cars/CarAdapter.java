package com.example.mycarapplication.cars;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mycarapplication.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.ViewHolder> {

    List<Car> cars;

    public CarAdapter(List<Car> cars) {
        this.cars = cars;
    }

    public CarAdapter() {

    }

    @NonNull
    @Override
    public CarAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.car_details_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarAdapter.ViewHolder holder, int position) {

        String brand = cars.get(position).getBrand();
        String model = cars.get(position).getModel();
        int year = cars.get(position).getYear();
        long km = cars.get(position).getKm();
        int monthlyKm= cars.get(position).getKmPerMonth();
        Date lastInspection = cars.get(position).getLastInspection();

        //Calendar nextInspection = cars.get(position).nextInspection();
        Calendar nextOilChange = cars.get(position).calculateNextOilChange();

        holder.brand.setText(cars.get(position).getBrand());
        holder.model.setText(cars.get(position).getModel());
        holder.year.setText(cars.get(position).getYear());
        holder.monthlyKm.setText(cars.get(position).getKmPerMonth());
        holder.brand.setText(cars.get(position).getBrand());
        String pattern = "dd/MM/yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(cars.get(position).nextInspection());

    }

    @Override
    public int getItemCount() {
        if(cars ==null){
            return 0;
        }else{
            return cars.size();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView brand;
        TextView model;
        TextView year;
        TextView km;
        TextView monthlyKm;
        TextView lastInspection;
        TextView nextInspection;
        TextView nextOilChange;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            brand = itemView.findViewById(R.id.carBrand);
            model = itemView.findViewById(R.id.carModel);
            year = itemView.findViewById(R.id.year);
            km = itemView.findViewById(R.id.title);
            monthlyKm = itemView.findViewById(R.id.monthlyKm);
            lastInspection = itemView.findViewById(R.id.lastInspection);
            nextInspection = itemView.findViewById(R.id.nextInpection);
            nextOilChange = itemView.findViewById(R.id.oilChange);

        }
    }

    public void updateData(List<Car> cars){
        this.cars = cars;
        notifyDataSetChanged();
    }
}


