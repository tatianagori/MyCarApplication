package com.example.mycarapplication.cars;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.mycarapplication.CarRepository;

import java.util.List;

public class CarViewModel extends AndroidViewModel {

    private static CarRepository repository;

    public CarViewModel(Application application) {
        super(application);
        repository = CarRepository.getInstance(application);
    }

    public LiveData<List<Car>> getAllCars() {
        return repository.getAllCars();
    }

    public static void addCar(final Car car){
        repository.addCar(car);
    }

    public LiveData<Car> getCarById(int id){
        return repository.getCarById(id);
    }

    public void deleteCar(int id){
        repository.deleteCar(id);
    }

}
