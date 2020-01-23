package com.example.notessavelyev;

import android.content.Context;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class NotesAdapter extends BaseAdapter {

    List<Note> notes;
    LayoutInflater layoutInflater;
    Context ctx;
    public static final String DATE_PATTERN = "dd.MM.yyyy HH:mm";

    NotesAdapter(Context context, List<Note> Notes) {
        ctx = context;
        notes = Notes;
        layoutInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
                Toast.makeText(ctx, " view onClick Позиция № " + Integer.toString(position + 1), Toast.LENGTH_SHORT).show();
            }
        });

        return view;

    }

}