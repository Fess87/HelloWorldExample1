package com.example.example521;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {
    private EditText login;
    private EditText password;
    private Button btnLogin;
    private Button btnRegistration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initviews();
        pushRegistration();
        pushLogin();
    }

    private void initviews(){
        login = findViewById(R.id.loginInput);
        password = findViewById(R.id.passwordInput);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegistration = findViewById(R.id.btnRegistration);
    }

    private void pushRegistration(){
        btnRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(login.getText().toString().equals("")&&password.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "Пустое поле логина и пароля", Toast.LENGTH_LONG).show();
                } else if(login.getText().toString().equals("")||password.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "Пустое поле логина или пароля", Toast.LENGTH_LONG).show();
                } else {
                    try {
                        FileOutputStream outputStream = openFileOutput("loginPassword.txt", MODE_PRIVATE);
                        String logPass = login.getText().toString()+";"+password.getText().toString();
                        outputStream.write(logPass.getBytes());
                        outputStream.close();
                        Toast.makeText(MainActivity.this, "Регистрация успешна!", Toast.LENGTH_LONG).show();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    private void pushLogin(){
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File file = new File(getFilesDir(), "loginPassword.txt");
                if(!file.exists()){
                    Toast.makeText(MainActivity.this,"Пока никто не регистрировался!!!", Toast.LENGTH_LONG).show();
                } else if(login.getText().toString().equals("")&&password.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "Пустое поле логина и пароля", Toast.LENGTH_LONG).show();
                } else if(login.getText().toString().equals("")||password.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "Пустое поле логина или пароля", Toast.LENGTH_LONG).show();
                } else {
                    try {
                        InputStreamReader inputStreamReader = new InputStreamReader(openFileInput("loginPassword.txt"));
                        BufferedReader reader = new BufferedReader(inputStreamReader);
                        String logPassStr = reader.readLine();
                        String []logPass = logPassStr.split(";");
                        inputStreamReader.close();
                        if(login.getText().toString().equals(logPass[0])&&password.getText().toString().equals(logPass[1])){
                            Toast.makeText(MainActivity.this, "Вы авторизованы", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(MainActivity.this, "Логин или пароль введены неверно", Toast.LENGTH_LONG).show();
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
