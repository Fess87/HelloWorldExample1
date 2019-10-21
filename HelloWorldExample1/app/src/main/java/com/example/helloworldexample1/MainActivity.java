package com.example.helloworldexample1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView text1 = (TextView) findViewById(R.id.finalTxt);
        final EditText editName = (EditText) findViewById(R.id.editUserName);
        final EditText editEmail = (EditText) findViewById(R.id.editUserEmail);
        Button button1 = (Button) findViewById(R.id.okButton);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            text1.setText(getString(R.string.txtSubscriptionDone)+ " " + editName.getText().toString() + " " + getString(R.string.txtOnEmail) + " " + editEmail.getText().toString());
            }
        });
        Button button2 = (Button) findViewById(R.id.buttonClear);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               text1.setText("");
               editName.setText("");
               editEmail.setText("");
            }
        });

    }
}
