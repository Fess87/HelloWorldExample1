package com.example.example511;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ArrayList<Product> products;
    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = findViewById(R.id.listView);
        initArrayProducts(loadProducts());
        BaseAdapter adapter = new ProductAdapter(this, products);
        listView.setAdapter(adapter);


    }

    private ArrayList loadProducts() {
        ArrayList<String> productsList = new ArrayList<>();
        try {
        File file = FileUtils.getProductsFile(this, false);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = reader.readLine();
        while (line != null) {
            productsList.add(line);
            line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return productsList;
    }

    private void initArrayProducts(ArrayList<String> productsList){
        for (String val:productsList) {
            String[] productchars = val.split(";");
            Product product = new Product(Integer.parseInt(productchars[0]), Integer.parseInt(productchars[1]),productchars[2],R.drawable.cat,Boolean.parseBoolean(productchars[3]), productchars[4]);
            products.add(product);
        }
    }


}
