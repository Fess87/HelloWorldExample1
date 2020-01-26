package com.example.notessavelyev;

import android.app.Application;

public class App extends Application {
    private static PinRepository pinRepository;
    private static NoteRepository noteRepository;

    public static PinRepository getPinRepository() {
        return pinRepository;
    }

    public static NoteRepository getNoteRepository() {
        return noteRepository;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        pinRepository = new HashedPinRepository(this);
        FileNoteRepository fileNoteRepository = new FileNoteRepository(this);
        fileNoteRepository.readNotesFromFile();
        noteRepository = fileNoteRepository;
    }
}