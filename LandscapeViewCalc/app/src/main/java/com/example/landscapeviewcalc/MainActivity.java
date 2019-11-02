package com.example.landscapeviewcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setView();
    }

    protected void setView(){
        Button ingenerView = findViewById(R.id.ingenerView);
        Button simpleView = findViewById(R.id.simpleView);

        ingenerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = findViewById(R.id.simpleLayout);
                View view2 = findViewById(R.id.ingenerLayout);
                view.setVisibility(View.INVISIBLE);
                view2.setVisibility(View.VISIBLE);
            }
        });

        simpleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = findViewById(R.id.simpleLayout);
                View view2 = findViewById(R.id.ingenerLayout);
                view2.setVisibility(View.INVISIBLE);
                view.setVisibility(View.VISIBLE);
            }
        });
    }
}
