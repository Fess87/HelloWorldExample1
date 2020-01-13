package com.example.notessavelyev;

import java.util.List;

interface NoteRepository {
    Note getNoteById(String id);

    List<Note> getNotes();

    void saveNote(Note note);

    void deleteById(String id);
}