package com.example.mycarapplication.cars;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuView;
import androidx.lifecycle.ViewModelProvider;

import com.example.mycarapplication.Database;
import com.example.mycarapplication.R;

public class AddCarActivity extends AppCompatActivity {


    private EditText year;
    private EditText km;
    private EditText inspectionDate;
    private CarViewModel carViewModel;
    private MenuItem editBrand;
    private MenuItem editModel;
    private Menu modelMenu;
    private Menu brandMenu;
    private MenuView brandview;
    private String brand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);


        carViewModel = new

                ViewModelProvider(this).

                get(CarViewModel.class);


        year =

                findViewById(R.id.yearTextNumber);

        km =

                findViewById(R.id.kmTextNumber);

        inspectionDate =

                findViewById(R.id.inspectionDateTextDate);

        modelMenu =

                findViewById(R.id.model_menu);

        brandMenu =

                findViewById(R.id.brand_menu);

        brandMenu.add("Mercedes");
        brandMenu.add("Audi");
        brandMenu.add("Seat");
        brandMenu.add("Toyota");
        brandMenu.add("BMW");
        brandMenu.add("VW");

        Car car = new Car("Mercedes", "AClass");
        new

                Car("Mercedes", "BClass");
        new

                Car("VW", "Polo");
        new

                Car("VW", "Golf");
        new

                Car("Toyota", "Yaris");
        new

                Car("Toyota", "Aygo");
        new

                Car("BMW", "3Series");
        new

                Car("BMW", "2Series");
        new

                Car("Seat", "Leon");
        new

                Car("Seat", "Ibiza");
        new

                Car("Audi", "A3");
        new

                Car("Audi", "A1");
        Database.getDatabase(

                getApplicationContext()).

                carDAO().

                addCar(car);


        Button button = findViewById(R.id.addCar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddCarActivity.this, MyCarFragment.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem brand) {
        int itemId = brand.getItemId();

        return true;
    }

    public boolean onCreateOptionsMenu1(Menu brandMenu) {
        getMenuInflater().inflate(R.menu.brand_menu, brandMenu);

        return super.onCreateOptionsMenu(brandMenu);
    }

    public boolean onCreateOptionsMenu2(Menu modelMenu) {
        getMenuInflater().inflate(R.menu.model_menu, modelMenu);
        return super.onCreateOptionsMenu(modelMenu);
    }

    public boolean onOptionsItemSelectedBrand(MenuItem brand) {
        brand.getItemId();

        return super.onOptionsItemSelected(brand);
    }

    public boolean onOptionsItemSelectedModel(MenuItem model) {
        model.getItemId();

        return super.onOptionsItemSelected(model);
    }

    public void addCar(View view){
        Car newCar = new Car(editBrand.getTitle().toString(),editModel.getTitle().toString(),
                inspectionDate, km, year);

        CarViewModel.addCar(newCar);
    }
}




