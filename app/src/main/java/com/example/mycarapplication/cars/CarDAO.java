package com.example.mycarapplication.cars;

import androidx.lifecycle.LiveData;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
public interface CarDAO {

    @Query("SELECT * FROM car_table")
    LiveData<List<Car>> getAllCars();

    @Insert
    void addCar(Car car);

    @Query("SELECT * FROM car_table WHERE id = :id")
    LiveData<Car> getCarById(int id);



    @Query("DELETE FROM car_table WHERE id = :id")
    void deleteCar(int id);

}
