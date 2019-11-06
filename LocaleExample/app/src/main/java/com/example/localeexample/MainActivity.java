package com.example.localeexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Spinner LanguagesSpinner;
    private Button OkButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initSpinnerLanguages();
    }

    private void initViews(){
        LanguagesSpinner = findViewById(R.id.spinnerLanguages);
        OkButton = findViewById(R.id.okButton);
    }

    private void initSpinnerLanguages() {
        ArrayAdapter<CharSequence> adapterLanguages = ArrayAdapter.createFromResource(this, R.array.language, android.R.layout.simple_spinner_item);
        adapterLanguages.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        LanguagesSpinner.setAdapter(adapterLanguages);
        LanguagesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int index, long l) {
                pressOkButton(index);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    private void pressOkButton(@Language final int index){
        OkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (index){
                    case Language.Russian:
                        Locale locale = new Locale("ru");
                        Configuration config = new Configuration();
                        config.setLocale(locale);
                        getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                        recreate();
                        break;
                    case Language.English:
                        Locale locale2 = new Locale("en");
                        Configuration config2 = new Configuration();
                        config2.setLocale(locale2);
                        getResources().updateConfiguration(config2, getBaseContext().getResources().getDisplayMetrics());
                        recreate();
                        break;
                    case Language.Deutsch:
                        Locale locale3 = new Locale("de");
                        Configuration config3 = new Configuration();
                        config3.setLocale(locale3);
                        getResources().updateConfiguration(config3, getBaseContext().getResources().getDisplayMetrics());
                        recreate();
                        break;
                }
            }
        });
    }
}
