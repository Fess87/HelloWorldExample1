package com.example.notessavelyev;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.example.notessavelyev.R.drawable.circle;
import static com.example.notessavelyev.R.drawable.circle2;

public class VerificationActivity extends AppCompatActivity {

    String enterPin = "";
    int countpush=0;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;
    Button btn0;
    Button btnDel;
    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    TextView wrongPin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);
        verificationFile();
        initViews();
        enterPinCode();

    }

    protected void initViews(){
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

    protected void setColorForCircle(){
        switch (countpush) {
            case 0:imageView1.setImageResource(circle);
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

    protected void verificationCountNumber(){
        if (countpush==4){
            verificationPin();
        }
    }

    protected void enterPinCode(){
            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    enterPin=enterPin+"1";
                    countpush++;
                    verificationCountNumber();
                    setColorForCircle();
                }
            });
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    enterPin=enterPin+"2";
                    countpush++;
                    verificationCountNumber();
                    setColorForCircle();
                }
            });
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    enterPin=enterPin+"3";
                    countpush++;
                    verificationCountNumber();
                    setColorForCircle();
                }
            });
            btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    enterPin=enterPin+"4";
                    countpush++;
                    verificationCountNumber();
                    setColorForCircle();
                }
            });
            btn5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    enterPin=enterPin+"5";
                    countpush++;
                    verificationCountNumber();
                    setColorForCircle();
                }
            });
            btn6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    enterPin=enterPin+"6";
                    countpush++;
                    verificationCountNumber();
                    setColorForCircle();
                }
            });
            btn7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    enterPin=enterPin+"7";
                    countpush++;
                    verificationCountNumber();
                    setColorForCircle();
                }
            });
            btn8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    enterPin=enterPin+"8";
                    countpush++;
                    verificationCountNumber();
                    setColorForCircle();
                }
            });
            btn9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    enterPin=enterPin+"9";
                    countpush++;
                    verificationCountNumber();
                    setColorForCircle();
                }
            });
            btn0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    enterPin=enterPin+"0";
                    countpush++;
                    verificationCountNumber();
                    setColorForCircle();
                }
            });
            btnDel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(countpush>0){
                        countpush--;
                        enterPin=enterPin.substring(0,enterPin.length()-1);
                        setColorForCircle();
                    }


                }
            });

    }

    protected void verificationFile() {
        File file = new File(getFilesDir(), "pin.txt");
        if(!file.exists()){
            Intent intent = new Intent(VerificationActivity.this, SettingsActivity.class);
            startActivity(intent);
        }
    }

    protected void verificationPin(){
        String pinStr="fail";
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(openFileInput("pin.txt"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            pinStr = reader.readLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String getPinTxt = HashUtils.md5Custom(enterPin);
        if (getPinTxt.equals(pinStr)) {
            countpush=0;
            enterPin="";
            wrongPin.setText("");
            Intent intent1 = new Intent(VerificationActivity.this, NotesActivity.class);
            startActivity(intent1);

        } else{
            wrongPin.setText(R.string.wrongPin);
            countpush=0;
            enterPin="";
        }
    }

}
