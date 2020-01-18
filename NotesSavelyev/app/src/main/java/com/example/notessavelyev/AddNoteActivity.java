package com.example.notessavelyev;


import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class AddNoteActivity extends AppCompatActivity {

    EditText headNote;
    EditText bodyNote;
    CheckBox checkBoxhasDeadLine;
    ImageButton btnSetDeadLine;
    EditText editTextDeadLine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        setTitle(R.string.new_note);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initViews();
        setDeadline();
    }

    private void initViews() {
        headNote = findViewById(R.id.editTextHead);
        bodyNote = findViewById(R.id.editTextBody);
        checkBoxhasDeadLine = findViewById(R.id.checkBoxHasDeadLine);
        btnSetDeadLine = findViewById(R.id.btnSelectDeadLine);
        editTextDeadLine = findViewById(R.id.editTextDeadLine);
    }

    private void setDeadline() {
        checkBoxhasDeadLine.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    btnSetDeadLine.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            callDatePicker();
                        }
                    });
                    setTimeAndDateInEditTextDeadLine();
                } else if (!isChecked) {
                    editTextDeadLine.setText("");
                    editTextDeadLine.setHint(R.string.deadline);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_note, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == android.R.id.home) {
            Toast.makeText(this, "Домой", Toast.LENGTH_SHORT).show();
            this.finish();
        } else if (id == R.id.action_save) {
            Toast.makeText(this, "Сохранено", Toast.LENGTH_SHORT).show();
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void callDatePicker() {

        final Calendar cal = Calendar.getInstance();
        int mYear = cal.get(Calendar.YEAR);
        int mMonth = cal.get(Calendar.MONTH);
        int mDay = cal.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        String editTextDateParam = dayOfMonth + "." + (monthOfYear + 1) + "." + year;
                        editTextDeadLine.setText(editTextDateParam + " " + "0:00");
                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

    private void setTimeAndDateInEditTextDeadLine() {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        Calendar cal = Calendar.getInstance();
        ;
        editTextDeadLine.setText(dateFormat.format(cal.getTime()));
    }
}

