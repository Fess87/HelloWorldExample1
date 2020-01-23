package com.example.notessavelyev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.notessavelyev.R.drawable.circle;
import static com.example.notessavelyev.R.drawable.circle2;

public class VerificationActivity extends AppCompatActivity {

    private String enterPin = "";
    private int countpush = 0;
    private int LEGTHPIN = 4;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btn0;
    private Button btnDel;
    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageView imageView4;
    private TextView wrongPin;
    private PinRepository pinRepository = App.getPinRepository();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);
        verifyFile();
        initViews();
        enterPinCode();

    }

    private void initViews() {
        btn1 = findViewById(R.id.number1);
        btn2 = findViewById(R.id.number2);
        btn3 = findViewById(R.id.number3);
        btn4 = findViewById(R.id.number4);
        btn5 = findViewById(R.id.number5);
        btn6 = findViewById(R.id.number6);
        btn7 = findViewById(R.id.number7);
        btn8 = findViewById(R.id.number8);
        btn9 = findViewById(R.id.number9);
        btn0 = findViewById(R.id.number0);
        btnDel = findViewById(R.id.btnDelete);
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        wrongPin = findViewById(R.id.wrongPin);

    }

    private void setColorForCircle() {
        switch (countpush) {
            case 0:
                imageView1.setImageResource(circle);
                imageView2.setImageResource(circle);
                imageView3.setImageResource(circle);
                imageView4.setImageResource(circle);
                break;
            case 1:
                imageView1.setImageResource(circle2);
                imageView2.setImageResource(circle);
                imageView3.setImageResource(circle);
                imageView4.setImageResource(circle);
                break;
            case 2:
                imageView1.setImageResource(circle2);
                imageView2.setImageResource(circle2);
                imageView3.setImageResource(circle);
                imageView4.setImageResource(circle);
                break;
            case 3:
                imageView1.setImageResource(circle2);
                imageView2.setImageResource(circle2);
                imageView3.setImageResource(circle2);
                imageView4.setImageResource(circle);
                break;
            case 4:
                imageView1.setImageResource(circle2);
                imageView2.setImageResource(circle2);
                imageView3.setImageResource(circle2);
                imageView4.setImageResource(circle2);
                break;
        }
    }

    private void verifyCountNumber() {
        if (countpush == LEGTHPIN) {
            verifyPin();
        }
    }

    private void enterPinCode() {
        btn1.setOnClickListener(getNumberButtonClickListener("1"));
        btn2.setOnClickListener(getNumberButtonClickListener("2"));
        btn3.setOnClickListener(getNumberButtonClickListener("3"));
        btn4.setOnClickListener(getNumberButtonClickListener("4"));
        btn5.setOnClickListener(getNumberButtonClickListener("5"));
        btn6.setOnClickListener(getNumberButtonClickListener("6"));
        btn7.setOnClickListener(getNumberButtonClickListener("7"));
        btn8.setOnClickListener(getNumberButtonClickListener("8"));
        btn9.setOnClickListener(getNumberButtonClickListener("9"));
        btn0.setOnClickListener(getNumberButtonClickListener("0"));
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (countpush > 0) {
                    countpush--;
                    enterPin = enterPin.substring(0, enterPin.length() - 1);
                    setColorForCircle();
                }
            }
        });

    }

    private void verifyFile() {
        if (!pinRepository.isPinCodeSet()) {
            Intent intent = new Intent(VerificationActivity.this, SettingsActivity.class);
            startActivity(intent);
        }
    }


    private void verifyPin() {
        final String pinStr = pinRepository.getPin();
        final String getPinTxt = HashUtils.md5Custom(enterPin);
        if (getPinTxt.equals(pinStr)) {
            countpush = 0;
            enterPin = "";
            wrongPin.setText("");
            Intent intent = new Intent(VerificationActivity.this, NoteActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);

        } else {
            wrongPin.setText(R.string.wrongPin);
            countpush = 0;
            enterPin = "";
        }
    }

    private View.OnClickListener getNumberButtonClickListener(final String number) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enterPin = enterPin + number;
                countpush++;
                verifyCountNumber();
                setColorForCircle();
            }
        };
    }

}
