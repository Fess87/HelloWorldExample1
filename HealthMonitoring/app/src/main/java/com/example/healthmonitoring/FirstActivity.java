package com.example.healthmonitoring;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashSet;
import java.util.Set;

public class FirstActivity extends AppCompatActivity {
    Set<User> users = new HashSet<>();
    protected static final String TAG = "MyApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        saveUser(users);
        goToPressure();
        goToHealth();
    }

    protected void saveUser(final Set<User> users){
        Button button = findViewById(R.id.buttonSave);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText fio = findViewById(R.id.editName);
                EditText age = findViewById(R.id.editAge);
                Log.i(TAG, "Сохранение пользователя");
                try {
                    users.add(new User(fio.getText().toString(), Integer.valueOf(age.getText().toString())));
                    Toast.makeText(FirstActivity.this,getString(R.string.userSave),Toast.LENGTH_LONG).show();
                } catch (Exception ex){
                    Toast.makeText(FirstActivity.this,ex.getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    protected void goToPressure(){
        Button button = findViewById(R.id.buttonPressure);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                startActivity(intent);
                Log.i(TAG, "Переход к параметрам давления");
            }
        });
    }

    protected void goToHealth(){
        Button button = findViewById(R.id.buttonHearth);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this, ThirdActivity.class);
                startActivity(intent);
                Log.i(TAG, "Переход к жизненным показателям");
            }
        });
    }
}
