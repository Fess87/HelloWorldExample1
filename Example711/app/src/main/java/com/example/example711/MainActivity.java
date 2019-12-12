package com.example.example711;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.Time;
import java.time.LocalTime;

public class MainActivity extends AppCompatActivity {

    Button btnSync;
    TextView time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews(){
        btnSync = findViewById(R.id.btnSync);
        btnSync.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                String []times = getTimeNow().toString().split(":");
                Integer hour = Integer.valueOf(times[0]);
                Intent intent = new Intent(Intent.ACTION_SYNC);
                if(hour<14 && hour>=6){
                    intent.setData(Uri.parse("http://morning"));
                    startActivity(intent);
                } else if (hour<15 && hour>=14){
                    intent.setData(Uri.parse("http://afternoon"));
                    startActivity(intent);
                } else if (hour<6 || hour>=15){
                    intent.setData(Uri.parse("http://evening"));
                    startActivity(intent);
                }
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    protected static LocalTime getTimeNow(){
        LocalTime time = LocalTime.now();
    return time;
    }
}
