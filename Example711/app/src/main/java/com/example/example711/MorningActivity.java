package com.example.example711;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

public class MorningActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_morning);
        initViews();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void initViews(){
        TextView timeMorning = findViewById(R.id.timeMorning);
        timeMorning.setText(MainActivity.getTimeNow().toString());
    }
}
