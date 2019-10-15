package com.example.healthmonitoring;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ThirdActivity extends AppCompatActivity {
    List<VitalIndicators> list = new ArrayList<>();
    protected static final String TAG = "MyApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        saveHealth(list);
    }

    protected void saveHealth(final List<VitalIndicators> list){

        Button button = findViewById(R.id.buttonSaveHealth);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText weight = findViewById(R.id.editWeight);
                EditText steps = findViewById(R.id.editSteps);
                Log.i(TAG, "Сохранение жизненных показателей");
                try{
                list.add(new VitalIndicators(Double.parseDouble(weight.getText().toString()), Integer.parseInt(steps.getText().toString())));
                }catch (Exception ex){
                    Toast.makeText(ThirdActivity.this,ex.getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
