package com.example.notessavelyev;

import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

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
    private MutableLiveData<List<Note>> mutableNotes = new MutableLiveData<>();
    public FileNoteRepository(final Context context) {
        this.context = context;
    }
    @Override
    public Note getNoteById(String id) {

        return note;
    }
    @Override
    public LiveData<List<Note>> getNotes() {
        return mutableNotes;
    }
    public void readNotesFromFile() {
        List<Note> notes = new ArrayList<>();
        final File file = new File(context.getFilesDir(), FILE_NAME);
        if (!file.exists()) {
            Toast.makeText(context, R.string.haveNotNotes, Toast.LENGTH_LONG).show();
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
        mutableNotes.setValue(notes);
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
                notifyObservers(note);
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
                notifyObservers(note);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private void notifyObservers(Note note) {
        List<Note> value = mutableNotes.getValue();
        if (value == null) {
            value = new ArrayList<>();
        }
        value.add(note);
        mutableNotes.setValue(value);
    }
    private void notifyDelObservers(int id){
        List<Note> value = mutableNotes.getValue();
        if (value == null) {
            value = new ArrayList<>();
        }
        value.remove(id);
        mutableNotes.setValue(value);
    }


    @Override
    public void deleteById(int id) {
        String deadline;
        String notesToFile="";
        List<Note> notes = new ArrayList<>();
        final File file = new File(context.getFilesDir(), FILE_NAME);
        if (!file.exists()){
            Toast.makeText(context, R.string.haveNotNotes, Toast.LENGTH_LONG).show();
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
        notes.remove(id);
        for (Note note: notes) {
            if(note.isHasDeadLine()){
                deadline = note.getDeadlineDate();
            } else {
                deadline = " ";
            }
            String noteToString = note.getHead()+";-;"+note.getBody()+";-;"+deadline+";-;"+note.isHasDeadLine()+"\n";
            notesToFile = notesToFile + noteToString;
        }
        try {
            final FileOutputStream outputStream = context.openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
            outputStream.write(notesToFile.getBytes());
            outputStream.close();
            notifyDelObservers(id);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}