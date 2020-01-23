package com.example.notessavelyev;

import android.content.Context;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileNoteRepository implements NoteRepository {

    private final Context context;
    private final static String FILE_NAME = "notes.txt";
    Note note;

    public FileNoteRepository(final Context context) {
        this.context = context;
    }

    @Override
    public Note getNoteById(String id) {
        return note;
    }

    @Override
    public List<Note> getNotes() {
        List<Note> notes = new ArrayList<>();
        final File file = new File(context.getFilesDir(), FILE_NAME);
        if (!file.exists()) {
            Toast.makeText(context, "Заметок нет", Toast.LENGTH_LONG).show();
        } else {
            try {
                final InputStreamReader inputStreamReader = new InputStreamReader(context.openFileInput(FILE_NAME));
                final BufferedReader reader = new BufferedReader(inputStreamReader);
                String line = reader.readLine();
                while(line!=null){
                    String[] forNote = line.split(";-;");
                    Note note = new Note(forNote[0], forNote[1], Boolean.valueOf(forNote[3]), forNote[2]);
                    notes.add(note);
                    line = reader.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return notes;
    }

    @Override
    public void saveNote(Note note) {
        final File file = new File(context.getFilesDir(), FILE_NAME);
        if (!file.exists()) {
            try {
                final FileOutputStream outputStream = context.openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
                final String deadline;
                if(note.isHasDeadLine()){
                    deadline = note.getDeadlineDate();
                } else {
                    deadline = " ";
                }
                final String noteTostring = note.getHead()+";-;"+note.getBody()+";-;"+deadline+";-;"+note.isHasDeadLine()+"\n";
                outputStream.write(noteTostring.getBytes());
                outputStream.close();
            } catch (final IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                final InputStreamReader inputStreamReader = new InputStreamReader(context.openFileInput(FILE_NAME));
                final BufferedReader reader = new BufferedReader(inputStreamReader);
                String line = reader.readLine();
                StringBuilder output = new StringBuilder();
                while(line!=null){
                    output = output.append(line);
                    line = reader.readLine();
                }
                String notesInFile = output.toString();
                final FileOutputStream outputStream = context.openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
                final String deadline;
                if(note.isHasDeadLine()){
                    deadline = note.getDeadlineDate();
                } else {
                    deadline = " ";
                }
                final String noteTostring = note.getHead()+";-;"+note.getBody()+";-;"+deadline+";-;"+note.isHasDeadLine()+"\n";
                notesInFile = notesInFile + noteTostring;
                outputStream.write(notesInFile.getBytes());
                outputStream.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void deleteById(String id) {

    }
}
