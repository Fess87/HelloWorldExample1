package com.example.notessavelyev;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


import androidx.appcompat.app.AppCompatActivity;


import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import java.util.List;


public class NoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        NoteRepository noteRepository = App.getNoteRepository();


        ListView listViewNotes = findViewById(R.id.listViewNotes);

        List<Note> notes = noteRepository.getNotes();

        final NotesAdapter adapter = new NotesAdapter(this, notes);

        listViewNotes.setAdapter(adapter);

        adapter.notifyDataSetChanged();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NoteActivity.this, AddNoteActivity.class));
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_note, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_settings:
                startActivity(new Intent(NoteActivity.this, SettingsActivity.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
