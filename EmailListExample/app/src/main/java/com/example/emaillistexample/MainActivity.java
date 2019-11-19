package com.example.emaillistexample;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Random random = new Random();
    private EmailAdapter adapter;
    private List<Drawable> images = new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fillImages();
        initListView();
        generateRandomItemData();
        generateRandomItemData();
        generateRandomItemData();
        generateRandomItemData();
        generateRandomItemData();
        generateRandomItemData();
        generateRandomItemData();
    }


    private void initListView(){
        ListView list = findViewById(R.id.list);
        ArrayList<ItemMail> emails = new ArrayList<>();
        BaseAdapter adapter = new EmailAdapter(this, null);
        list.setAdapter(adapter);
    }

    private void fillImages() {
        images.add(ContextCompat.getDrawable(MainActivity.this,
                android.R.drawable.ic_menu_report_image));
        images.add(ContextCompat.getDrawable(MainActivity.this,
                android.R.drawable.ic_menu_add));
        images.add(ContextCompat.getDrawable(MainActivity.this,
                android.R.drawable.ic_menu_agenda));
        images.add(ContextCompat.getDrawable(MainActivity.this,
                android.R.drawable.ic_menu_camera));
        images.add(ContextCompat.getDrawable(MainActivity.this,
                android.R.drawable.ic_menu_call));
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void generateRandomItemData() {
        adapter.addItem(new ItemMail("Email #"+adapter.getCount(),"HeadEmail"+adapter.getCount(),"This is text in email",images.get(random.nextInt(images.size())),random.nextBoolean()));

    }
}
