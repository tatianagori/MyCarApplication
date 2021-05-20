package com.example.mycarapplication.cars;


import android.widget.EditText;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Calendar;
import java.util.Date;

@Entity(tableName = "car_table")
public class Car {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String brand;
    private String model;
    private int year;
    private int km;
    private int kmPerMonth;
    private Date lastInspection;
    Calendar date = Calendar.getInstance();

    public Car(){

    }

    public Car(String brand) {
        this.brand = brand;
    }


    public Car(int id, String brand, String model, int year, int km, int kmPerMonth, String imageUrl, Date lastInspection, Date lastTireChange, Date roadTax) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.km = km;
        this.kmPerMonth= kmPerMonth;
        this.lastInspection = lastInspection;
    }

    public Car (String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public Car(int year, int km, Date lastInspection){
        this.year = year;
        this.km = km;
        this.lastInspection = lastInspection;
    }


    public Car(String toString, String toString1, EditText inspectionDate, EditText km, EditText year) {
    }

    //Calculating next oil change based on the year of the car and the km per month
    public Calendar calculateNextOilChange() {

        if (year < 2010 && kmPerMonth < 1000) {

            date.add(Calendar.MONTH, 3);

        } else if (year < 2010 && kmPerMonth < 3000) {
            date.add(Calendar.MONTH, 2);

        } else if (year < 2010 && kmPerMonth < 5000) {
            date.add(Calendar.MONTH, 1);

        } else if (year < 2010 && kmPerMonth < 8000) {
            return date;
        }
        else if(year>=2010 && kmPerMonth <1000){
            date.add(Calendar.MONTH, 8);
        }
        else if(year >= 2010 && kmPerMonth < 2000){
            date.add(Calendar.MONTH, 4);
        }
        else if(year >= 2010 && kmPerMonth < 5000){
            date.add(Calendar.MONTH, 2);
        }
        else if(year >= 2010 && kmPerMonth < 8000){
            date.add(Calendar.MONTH, 1);
        }

        return date;
    }

    //Calculating next inspection day

    public Calendar nextInspection(){
        date.add(Calendar.YEAR,1);
        return date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public long getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public int getKmPerMonth() {
        return kmPerMonth;
    }

    public void setKmPerMonth(int kmPerMonth) {
        this.kmPerMonth = kmPerMonth;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public Date getLastInspection() {
        return lastInspection;
    }

    public void setLastInspection(Date lastInspection) {
        this.lastInspection = lastInspection;
    }



    @Override
    public String toString() {
        return "Car{" +
                "Id='" + id + '\'' +
                "Brand='" + brand + '\'' +
                ", Model='" + model + '\'' +
                ", Year=" + year +
                ", Km=" + km +
                ", KmPerMonth=" + kmPerMonth +
                ", LastInspection=" + lastInspection +
                '}';
    }
}
