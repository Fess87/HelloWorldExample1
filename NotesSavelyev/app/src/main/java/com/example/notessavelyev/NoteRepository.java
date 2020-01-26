package com.example.notessavelyev;

import androidx.lifecycle.LiveData;

import java.util.List;

interface NoteRepository {
    Note getNoteById(String id);

    LiveData<List<Note>> getNotes();

    void saveNote(Note note);

    void deleteById(int id);
}