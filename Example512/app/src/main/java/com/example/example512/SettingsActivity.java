package com.example.example512;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.Objects;

public class SettingsActivity extends AppCompatActivity {

    private static final int MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 10;
    public static final int IMAGE_RESULT_CODE = 543;
    private static final String IMAGE_RESULT_KEY = "IMAGE_RESULT_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Boolean granted = ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_GRANTED;
        if (granted) {
           checkExternalStorageReadable();
        }else {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE);
        }
    }

    private void checkExternalStorageReadable(){
        if(isExternalStorageReadable()){
            setup();
        } else {
            Toast.makeText(this, "Внешнее хранилище недоступно",Toast.LENGTH_LONG).show();
        }
    }

    private static boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        }
        return false;
    }

    private void setup(){
        Button btnSet = findViewById(R.id.btnOk);
        btnSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tw = findViewById(R.id.picturesLink);
                String picturesName = tw.getText().toString();
                final File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), picturesName);
                if (file.exists()) {
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra(IMAGE_RESULT_KEY, file);
                    setResult(IMAGE_RESULT_CODE, resultIntent);
                    finish();
                } else {
                    Toast.makeText(SettingsActivity.this, "Такого файла нет!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode== MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE){
            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                checkExternalStorageReadable();
            } else {
                Toast.makeText(this,"Печально",Toast.LENGTH_SHORT).show();
            }
            return;
        }
    }

    public static Bitmap getImageFromIntent(@NonNull Intent intent) {
        File imageFile = (File) intent.getSerializableExtra(IMAGE_RESULT_KEY);
        return BitmapFactory.decodeFile(Objects.requireNonNull(imageFile).getAbsolutePath());
    }

}
