package com.example.example611;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        Log.d("Lifecycle", "onCreate");
        textView.append("\n" + "onCreate");
        Button button = findViewById(R.id.button);
        if(savedInstanceState ==null){
            textView.append("\n" + "бандл пустой");
        } else {
            textView.append("\n" + "бандл не пустой");
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        textView = findViewById(R.id.textView);
        Log.d("Lifecycle", "onStart");
        textView.append("\n" + "onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        textView = findViewById(R.id.textView);
        Log.d("Lifecycle", "onPause");
        textView.append("\n" + "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        textView = findViewById(R.id.textView);
        Log.d("Lifecycle", "onResume");
        textView.append("\n" + "onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        textView = findViewById(R.id.textView);
        Log.d("Lifecycle", "onStop");
        textView.append("\n" + "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        textView = findViewById(R.id.textView);
        Log.d("Lifecycle", "onRestart");
        textView.append("\n" + "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        textView = findViewById(R.id.textView);
        Log.d("Lifecycle", "onDestroy");
        textView.append("\n" + "onDestroy");
    }




    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        textView = findViewById(R.id.textView);
        Log.d("Lifecycle", "onPostCreate");
        textView.append("\n" + "onPostCreate");
    }


    @Override
    protected void onPostResume() {
        super.onPostResume();
        textView = findViewById(R.id.textView);
        Log.d("Lifecycle", "onPostResume");
        textView.append("\n" + "onPostResume");
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        textView = findViewById(R.id.textView);
        Log.d("Lifecycle", "onKeyDown");
        textView.append("\n" + "onKeyDown");
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        textView = findViewById(R.id.textView);
        Log.d("Lifecycle", "onBackPressed");
        textView.append("\n" + "onBackPressed");
    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        textView = findViewById(R.id.textView);
        Log.d("Lifecycle", "onKeyLongPress");
        textView.append("\n" + "onKeyLongPress");
        return super.onKeyLongPress(keyCode, event);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        textView = findViewById(R.id.textView);
        Log.d("Lifecycle", "onSaveInstanceState");
        textView.append("\n" + "onSaveInstanceState");
        outState.putString("key", "Запись в бандл в методе onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        textView = findViewById(R.id.textView);
        Toast.makeText(MainActivity.this,savedInstanceState.getString("key"),Toast.LENGTH_LONG);
        Log.d("Lifecycle", "onRestoreInstanceState");
        textView.append("\n" + "onRestoreInstanceState");
        textView.append("\n" + savedInstanceState.getString("key"));
    }
}
