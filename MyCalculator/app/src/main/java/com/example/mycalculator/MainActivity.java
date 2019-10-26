package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView number1;
    private TextView number2;
    private TextView number3;
    private TextView number4;
    private TextView number5;
    private TextView number6;
    private TextView number7;
    private TextView number8;
    private TextView number9;
    private TextView number0;
    private TextView point;
    private TextView editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    protected void initViews(){
        number0 = findViewById(R.id.number0);
        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);
        number3 = findViewById(R.id.number3);
        number4 = findViewById(R.id.number4);
        number5 = findViewById(R.id.number5);
        number6 = findViewById(R.id.number6);
        number7 = findViewById(R.id.number7);
        number8 = findViewById(R.id.number8);
        number9 = findViewById(R.id.number9);
        point = findViewById(R.id.point);
        editText = findViewById(R.id.editText);
        number0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString()+"0");
            }
        });
        number1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString()+"1");
            }
        });
        number2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString()+"2");
            }
        });
        number3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString()+"3");
            }
        });
        number4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString()+"4");
            }
        });
        number5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString()+"5");
            }
        });
        number6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString()+"6");
            }
        });
        number7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString()+"7");
            }
        });
        number8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString()+"8");
            }
        });
        number9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString()+"9");
            }
        });
        point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString()+".");
            }
        });
    }
}
