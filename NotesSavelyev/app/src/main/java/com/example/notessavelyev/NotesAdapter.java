package com.example.notessavelyev;

import android.content.Context;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Objects;


public class NotesAdapter extends BaseAdapter {
    List<Note> notes = Collections.emptyList();
    LayoutInflater layoutInflater;
    Context ctx;
    static final String DATE_PATTERN = "dd.MM.yyyy HH:mm";
    NoteRepository noteRepository = App.getNoteRepository();

    NotesAdapter(Context context) {
        ctx = context;
        layoutInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return notes.size();
    }

    @Override
    public Object getItem(int position) {
        return notes.get(position);
    }

    public Note getNote(int position) {
        return notes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.note_item, parent, false);
        }
        final Note Note = getNote(position);
        ((TextView) (view.findViewById(R.id.textViewBody))).setText(Note.getBody());
        ((TextView) (view.findViewById(R.id.textViewHead))).setText(Note.getHead());
        // Форматирование времени как "день.месяц.год"
        DateFormat dateFormat = new SimpleDateFormat(DATE_PATTERN, Locale.getDefault());
        String dateText = null;
        try {
            dateText = dateFormat.format(Objects.requireNonNull(dateFormat.parse(Note.getDeadlineDate())));
        } catch (ParseException e) {
            Log.e("NotesAdapter", "Неправильный формат!");
        }
        ((TextView) (view.findViewById(R.id.textViewDeadLineDay))).setText(dateText);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ctx, AddNoteActivity.class);
                Bundle extras = new Bundle();
                extras.putInt("position", position);
                extras.putString("head", Note.getHead());
                extras.putString("body", Note.getBody());
                extras.putString("deadlineDate", Note.getDeadlineDate());
                extras.putBoolean("isDeadline", Note.isHasDeadLine());
                intent.putExtras(extras);
                ctx.startActivity(intent);
            }
        });

        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                noteRepository.deleteById(position);
                return true;
            }
        });
        return view;
    }
}
