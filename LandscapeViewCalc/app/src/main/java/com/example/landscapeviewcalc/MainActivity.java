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
        View view = findViewById(R.id.ingenerLayout);
        view.setVisibility(View.INVISIBLE);
        setView();
    }

    protected void setView(){

        Button button = findViewById(R.id.ingenerView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = findViewById(R.id.simpleLayout);
                View view2 = findViewById(R.id.ingenerLayout);
                view.setVisibility(View.INVISIBLE);
                view2.setVisibility(View.VISIBLE);

            }
        });

        Button button2 = findViewById(R.id.simpleView);
        button2.setOnClickListener(new View.OnClickListener() {
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
