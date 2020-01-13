package com.example.notessavelyev;

import android.content.Context;

import java.util.List;

public class FileNoteRepository implements NoteRepository {

    private final Context context;
    private final static String FILE_NAME = "note.txt";

    public FileNoteRepository(final Context context) {
        this.context = context;
    }

    @Override
    public Note getNoteById(String id) {
        return null;
    }

    @Override
    public List<Note> getNotes() {
        return null;
    }

    @Override
    public void saveNote(Note note) {

    }

    @Override
    public void deleteById(String id) {

    }
}
