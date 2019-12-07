package com.example.example522;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {
    private EditText login;
    private EditText password;
    private Button btnLogin;
    private Button btnRegistration;
    private CheckBox checkBoxLogPass;
    private SharedPreferences sharedPref;
    private static String NOTE_TEXT = "note_text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initviews();
        getFromSharedPref();
        checkboxChecked();
    }

    private void initviews(){
        login = findViewById(R.id.loginInput);
        password = findViewById(R.id.passwordInput);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegistration = findViewById(R.id.btnRegistration);
        checkBoxLogPass = findViewById(R.id.checkboxLogPass);
        sharedPref = getSharedPreferences("checkBoxState", MODE_PRIVATE);
    }

    private void saveInSharedPref(){
        SharedPreferences.Editor myEditor = sharedPref.edit();
        Boolean checkBoxState = checkBoxLogPass.isChecked();
        String val = checkBoxState.toString();
        myEditor.putString(NOTE_TEXT, val);
        myEditor.apply();
    }

    private void getFromSharedPref(){
        String noteTxt = sharedPref.getString(NOTE_TEXT, "");
        Boolean valueCheckBox = Boolean.valueOf(noteTxt);
        checkBoxLogPass.setChecked(valueCheckBox);
    }

    private void checkboxChecked(){
        checkBoxLogPass.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                saveInSharedPref();
                if(checkBoxLogPass.isChecked()){
                    pushRegistrationExternal();
                    pushLoginExternal();
                    Toast.makeText(MainActivity.this, "Работаем с внешним хранилищем", Toast.LENGTH_LONG).show();
                } else if(!checkBoxLogPass.isChecked()){
                    pushRegistration();
                    pushLogin();
                    Toast.makeText(MainActivity.this, "Работаем с внутренним хранилищем", Toast.LENGTH_LONG).show();
                }
            }
        });
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

    private void pushRegistrationExternal(){
        btnRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(login.getText().toString().equals("")&&password.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "Пустое поле логина и пароля", Toast.LENGTH_LONG).show();
                } else if(login.getText().toString().equals("")||password.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "Пустое поле логина или пароля", Toast.LENGTH_LONG).show();
                } else {
                    File file = new File(getExternalFilesDir(null), "loginPassword.txt");

                    if(!file.exists()){
                        try {
                            file.createNewFile();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        file.delete();
                        try {
                            file.createNewFile();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    String logPass = login.getText().toString()+";"+password.getText().toString();
                    try {
                        FileWriter fw = new FileWriter(file);
                        fw.write(logPass);
                        fw.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Toast.makeText(MainActivity.this, "Регистрация успешна!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void pushLoginExternal(){
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File file = new File(getExternalFilesDir(null), "loginPassword.txt");
                if(!file.exists()){
                    Toast.makeText(MainActivity.this,"Пока никто не регистрировался!!!", Toast.LENGTH_LONG).show();
                } else if(login.getText().toString().equals("")&&password.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "Пустое поле логина и пароля", Toast.LENGTH_LONG).show();
                } else if(login.getText().toString().equals("")||password.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "Пустое поле логина или пароля", Toast.LENGTH_LONG).show();
                } else {
                    try {
                        BufferedReader br = new BufferedReader(new FileReader(file));
                        String logPassString = br.readLine();
                        String []loginPassword = logPassString.split(";");
                        if(login.getText().toString().equals(loginPassword[0])&&password.getText().toString().equals(loginPassword[1])){
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
