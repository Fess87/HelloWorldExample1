package com.example.example511;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ArrayList<Product> products = new ArrayList<>();
    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = findViewById(R.id.listView);
        initArrayProducts(loadProducts());
        Button btn = findViewById(R.id.btnAdd);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    addProduct();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        BaseAdapter adapter = new ProductAdapter(this, products);
        listView.setAdapter(adapter);

    }

    private void addProduct() throws IOException {
        TextView productName = findViewById(R.id.productName);
        TextView productPrice = findViewById(R.id.productPrice);
        TextView productCount = findViewById(R.id.productCount);
        TextView productDescription = findViewById(R.id.productDescription);
        Product product = new Product(Integer.parseInt(productPrice.getText().toString()),Integer.valueOf(productCount.getText().toString()), productName.getText().toString(),"cat" ,false, productDescription.getText().toString());
        products.add(product);
        ArrayList<String> productsList = new ArrayList<>();
        for (Product val: products) {
            productsList.add(val.getPrice()+";"+val.getQuantity()+";"+val.getName()+";"+val.getImage()+";"+val.isCheckbox()+";"+val.getDescription());
        }
        FileUtils.updateItemsFile(this,productsList);
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
            Product product = new Product(Integer.parseInt(productchars[0]), Integer.parseInt(productchars[1]),productchars[2],productchars[3],Boolean.parseBoolean(productchars[4]), productchars[5]);
            products.add(product);
        }
    }


}
