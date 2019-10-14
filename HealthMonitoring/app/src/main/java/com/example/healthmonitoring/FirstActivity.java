package com.example.healthmonitoring;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashSet;
import java.util.Set;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        Set<User> users = new HashSet<>();
        saveuser(users);
    }

    protected void saveuser (final Set<User> users){

        Button button = findViewById(R.id.buttonSave);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String TAG = "MyApp";
                EditText fio = findViewById(R.id.editName);
                EditText age = findViewById(R.id.editAge);
                try {
                    int age1 = Integer.valueOf(age.toString());
                    String fio1 = fio.toString();
                    users.add(new User(fio1, age1));
                } catch (Exception ex){
                    Toast.makeText(FirstActivity.this,ex.getMessage(),Toast.LENGTH_LONG).show();
                } finally {
                    Log.i(TAG, "Сохранение пользователя");
                }
            }
        });
    }
}
