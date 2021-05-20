package com.example.mycarapplication;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.mycarapplication.cars.Car;
import com.example.mycarapplication.cars.CarDAO;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CarRepository {

    private CarDAO carDAO;
    private static CarRepository instance;
    private ExecutorService executorService;

    private CarRepository(Application application) {
        Database database = Database.getDatabase(application);
        carDAO = database.carDAO();
        executorService = Executors.newFixedThreadPool(2);
    }

    public static synchronized CarRepository getInstance(Application application) {
        if (instance == null) {
            instance = new CarRepository(application);
        }
        return instance;
    }


    public LiveData<List<Car>> getAllCars() {
        return carDAO.getAllCars();
    }

    public void addCar(Car car) {
        executorService.execute(() -> carDAO.addCar(car));
    }

    public LiveData<Car> getCarById(int id){
        return carDAO.getCarById(id);
    }

    public void deleteCar(int id){
        executorService.execute(() -> carDAO.deleteCar(id));
    }
}
