package com.example.notessavelyev;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {

    private Button btnSave;
    private EditText editPin;
    private TextView warningPin;
    private int LEGTHPIN = 4;
    private PinRepository pinRepository = App.getPinRepository();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        getHomeButton();
        initViews();

    }

    private void getHomeButton(){
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    private void initViews(){
        btnSave = findViewById(R.id.btnSave);
        editPin = findViewById(R.id.pinCode);
        warningPin = findViewById(R.id.warningPin);
        savePin();
    }

    private void savePin(){
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String pin = editPin.getText().toString();
                if (pin.length() == LEGTHPIN) {
                    pinRepository.setPin(pin);
                    Toast.makeText(SettingsActivity.this, R.string.savePin, Toast.LENGTH_LONG).show();
                    final Intent intent = new Intent(SettingsActivity.this, NoteActivity.class);
                    startActivity(intent);
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
