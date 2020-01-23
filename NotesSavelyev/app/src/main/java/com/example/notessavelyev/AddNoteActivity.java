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

    private EditText headNote;
    private EditText bodyNote;
    private CheckBox checkBoxhasDeadLine;
    private ImageButton btnSetDeadLine;
    private EditText editTextDeadLine;
    NoteRepository noteRepository = App.getNoteRepository();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
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
        editTextDeadLine.setEnabled(false);
        btnSetDeadLine.setEnabled(false);
        checkBoxhasDeadLine.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    btnSetDeadLine.setEnabled(true);
                    btnSetDeadLine.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            callDatePicker();
                        }
                    });
                    editTextDeadLine.setEnabled(true);
                    setTimeAndDateInEditTextDeadLine();
                } else {
                    editTextDeadLine.setText("");
                    editTextDeadLine.setHint(R.string.deadline);
                    editTextDeadLine.setEnabled(false);
                    btnSetDeadLine.setEnabled(false);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add_note, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == android.R.id.home) {
            Toast.makeText(this, R.string.home, Toast.LENGTH_SHORT).show();
            this.finish();
        } else if (id == R.id.action_save) {
            saveNote();
            Toast.makeText(this, R.string.saved, Toast.LENGTH_SHORT).show();
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void callDatePicker() {

        final Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        String editTextDateParam = dayOfMonth + "." + (monthOfYear + 1) + "." + year;
                        editTextDeadLine.setText(editTextDateParam + " " + "0:00");
                    }
                }, year, month, day);
        datePickerDialog.show();
    }

    private void setTimeAndDateInEditTextDeadLine() {
        DateFormat dateFormat = new SimpleDateFormat(NotesAdapter.DATE_PATTERN);
        Calendar cal = Calendar.getInstance();
        editTextDeadLine.setText(dateFormat.format(cal.getTime()));
    }

    private void saveNote(){
        String deadline;
        if(checkBoxhasDeadLine.isChecked()){
            deadline = String.valueOf(editTextDeadLine.getText());
        } else {
            deadline = " ";
        }
        String head = String.valueOf(headNote.getText());
        String body = String.valueOf(bodyNote.getText());
        Note note = new Note(head, body, checkBoxhasDeadLine.isChecked(), deadline);
        noteRepository.saveNote(note);
    }
}

