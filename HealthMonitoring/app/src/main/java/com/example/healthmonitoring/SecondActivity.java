package com.example.healthmonitoring;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {
    List<IndividualIndicators> list = new ArrayList<>();
    protected static final String TAG = "MyApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        savePressure(list);
    }

    protected void savePressure(final List<IndividualIndicators> list){
        Button button = findViewById(R.id.buttonSavePressure);
        button.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                EditText highPressure = findViewById(R.id.editHighPressure);
                EditText lowPressure = findViewById(R.id.editLowPressure);
                EditText pulse = findViewById(R.id.editPulse);
                CheckBox tachycardia = findViewById(R.id.tachycardia);
                Log.i(TAG, "Сохранение параметров давления");
                try {
                    list.add(new IndividualIndicators(Integer.valueOf(highPressure.getText().toString()), Integer.valueOf(lowPressure.getText().toString()), Integer.valueOf(pulse.getText().toString()), tachycardia.isChecked()));
                    Toast.makeText(SecondActivity.this,getString(R.string.dataSave),Toast.LENGTH_LONG).show();
                } catch (Exception ex){
                    Toast.makeText(SecondActivity.this,ex.getMessage(),Toast.LENGTH_LONG).show();
                }
                }
        });
    }
}
