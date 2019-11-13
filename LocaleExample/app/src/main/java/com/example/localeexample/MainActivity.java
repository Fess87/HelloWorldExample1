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
    private Spinner ColorSpinner;
    private Button okButton;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_main);
        initViews();
        initSpinnerLanguages();
    }


    private void initViews() {
        LanguagesSpinner = findViewById(R.id.spinnerLanguages);
        ColorSpinner = findViewById(R.id.spinnerColors);
        okButton = findViewById(R.id.okButton);           }

    private void initSpinnerLanguages() {
        final ArrayAdapter<CharSequence> adapterLanguages = ArrayAdapter.createFromResource(this, R.array.language, android.R.layout.simple_spinner_item);
        adapterLanguages.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        LanguagesSpinner.setAdapter(adapterLanguages);
        LanguagesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(final AdapterView<?> adapterView, final View view, final int index, final long l) {
                initSpinnerColors(index);
            }

            @Override
            public void onNothingSelected(final AdapterView<?> adapterView) {
            }
        });
    }

    private void initSpinnerColors(final int indexLanguage) {
        final ArrayAdapter<CharSequence> adapterColors = ArrayAdapter.createFromResource(this, R.array.color, android.R.layout.simple_spinner_item);
        adapterColors.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ColorSpinner.setAdapter(adapterColors);
        ColorSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(final AdapterView<?> adapterView, final View view, final int indexColor, final long l) {
                pressOkButton(indexLanguage, indexColor);
            }

            @Override
            public void onNothingSelected(final AdapterView<?> adapterView) {
            }
        });
    }

    private void pressOkButton(@Language final int indexLanguage, @Color final int indexColor) {
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                final Locale locale = createLocaleFromLanguage(indexLanguage);
                applyLocale(locale);
                switch (indexColor){
                    case Color.Green:
                        Utils.changeToTheme(MainActivity.this, Utils.THEME_GREEN);
                        break;
                    case Color.Black:
                        Utils.changeToTheme(MainActivity.this, Utils.THEME_BLACK);
                        break;
                    case Color.Blue:
                        Utils.changeToTheme(MainActivity.this, Utils.THEME_BLUE);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown index: " + indexColor);
                }
            }
        });
    }


    private Locale createLocaleFromLanguage(@Language final int index) {
        final String language;
        switch (index) {
            case Language.Russian:
                language = "ru";
                break;
            case Language.English:
                language = "en";
                break;
            case Language.Deutsch:
                language = "de";
                break;
            default:
                throw new IllegalArgumentException("Unknown index: " + index);
        }

        return new Locale(language);
    }

    private void applyLocale(final Locale locale) {
        final Configuration config = new Configuration();
        config.setLocale(locale);
        getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        recreate();
    }
}



