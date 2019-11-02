package com.example.mychaintext;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

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
    private TextView cancel;
    private TextView plus;
    private TextView minus;
    private TextView splitup;
    private TextView multiply;
    private TextView equally;
    private TextView precent;
    private TextView plusMinus;

    private Float value1;
    private Float value2;
    private Float rezult;
    private String sign;

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
        cancel = findViewById(R.id.cancel);
        equally = findViewById(R.id.equally);
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        multiply = findViewById(R.id.multiply);
        splitup = findViewById(R.id.splitup);
        precent = findViewById(R.id.precent);
        plusMinus = findViewById(R.id.plus_minus);

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
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sign = "+";
                if(!editText.getText().toString().equals("")){
                    value1 = Float.valueOf(editText.getText().toString());
                }
                editText.setText("");
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sign = "-";
                if(!editText.getText().toString().equals("")){
                    value1 = Float.valueOf(editText.getText().toString());
                }
                editText.setText("");
            }
        });
        splitup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sign = "/";
                if(!editText.getText().toString().equals("")){
                    value1 = Float.valueOf(editText.getText().toString());
                }
                editText.setText("");
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sign = "*";
                if(!editText.getText().toString().equals("")){
                    value1 = Float.valueOf(editText.getText().toString());
                }
                editText.setText("");
            }
        });
        plusMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, getString(R.string.error), Toast.LENGTH_LONG).show();
                } else if(Float.valueOf(editText.getText().toString())>0){
                    editText.setText("-"+editText.getText().toString());
                } else if(Float.valueOf(editText.getText().toString())<0){
                    editText.setText(editText.getText().toString().substring(1));
                }
            }
        });
        precent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!editText.getText().toString().equals("")){
                    value1 = Float.valueOf(editText.getText().toString())/100;
                    editText.setText(value1.toString());
                } else {
                    Toast.makeText(MainActivity.this, getString(R.string.error), Toast.LENGTH_LONG).show();
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("");
                value1 = 0F;
                value2 = 0F;
            }
        });
        equally.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value2 = Float.valueOf(editText.getText().toString());
                switch (sign){
                    case "+":
                        rezult = value1+value2;
                        editText.setText(rezult.toString());
                        break;
                    case "-":
                        rezult = value1-value2;
                        editText.setText(rezult.toString());
                        break;
                    case "*":
                        rezult = value1*value2;
                        editText.setText(rezult.toString());
                        break;
                    case "/":
                        if(value2!=0F){rezult = value1/value2;
                            editText.setText(rezult.toString());
                        } else {
                            Toast.makeText(MainActivity.this, getString(R.string.splitonzero), Toast.LENGTH_LONG).show();
                        }


                        break;
                }
                value1=rezult;
            }
        });
    }
}
