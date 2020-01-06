package com.example.notessavelyev;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class SettingsActivity extends AppCompatActivity {

    Button btnSave;
    EditText editPin;
    TextView warningPin;
    private SharedPreferences mySharedPref;
    private static String PIN_CODE = "pin_code";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        setTitle(R.string.settings);
        getHomeButton();
        initViews();

    }

    protected void getHomeButton(){
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    protected void initViews(){
        btnSave = findViewById(R.id.btnSave);
        editPin = findViewById(R.id.pinCode);
        warningPin = findViewById(R.id.warningPin);
        savePin();
    }

    protected void savePin(){
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editPin.getText().toString().length()==4){
                    File file = new File(getFilesDir(), "pin.txt");
                    if(!file.exists()){
                        try {
                            FileOutputStream outputStream = openFileOutput("pin.txt", MODE_PRIVATE);
                            String hashPin = HashUtils.md5Custom(editPin.getText().toString());
                            outputStream.write(hashPin.getBytes());
                            outputStream.close();
                            Toast.makeText(SettingsActivity.this, "Пин-код сохранен!", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(SettingsActivity.this, NotesActivity.class);
                            startActivity(intent);
                        } catch (FileNotFoundException e) {
                        e.printStackTrace();
                        } catch (IOException e) {
                        e.printStackTrace();
                        }
                    }
                } else {
                    warningPin.setText(R.string.warning_pin);
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
