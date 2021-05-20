package com.example.mycarapplication;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.mycarapplication.cars.Car;
import com.example.mycarapplication.cars.CarDAO;


@androidx.room.Database(entities= {Car.class}, version = 4)
public abstract class Database extends RoomDatabase {

    public static Database instance;
    private static final int NUMBER_OF_THREADS =1;
    public abstract CarDAO carDAO();


    public static Database getDatabase(final Context context) {
        if (instance == null) {
            synchronized (Database.class) {
                if (instance == null) {
                    instance = Room.databaseBuilder(context.getApplicationContext(),
                            Database.class, "database")
                            .build();
                }
            }
        }
        return instance;
    }



}
