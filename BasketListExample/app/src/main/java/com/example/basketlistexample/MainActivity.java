package com.example.basketlistexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Random random = new Random();

        ListView listView = findViewById(R.id.listView);
        ArrayList<Product> products = new ArrayList<>();

        products.add(new Product(10,2,"Котик", R.drawable.cat, random.nextBoolean(), "Просто котик"));
        products.add(new Product(50,1,"Самолет", R.drawable.airplan, random.nextBoolean(), "Самый лучший самолетик"));
        products.add(new Product(15,2,"Баскетбольный мяч", R.drawable.basketball, random.nextBoolean(), "Не настоящий!!!!"));
        products.add(new Product(10,2,"Мяч для футбола", R.drawable.football, random.nextBoolean(), "Возраст: 8+"));
        products.add(new Product(10,2,"Велосипед", R.drawable.bike, random.nextBoolean(), "Для детей от 5 лет."));
        products.add(new Product(10,2,"Лошадка", R.drawable.horse, random.nextBoolean(), "Деревянные игрушки, прибитые к полу."));
        products.add(new Product(10,2,"BMW", R.drawable.car, random.nextBoolean(), "Как настоящий!!!"));

        BaseAdapter adapter = new ProductAdapter(this, products);
        listView.setAdapter(adapter);

    }
}
