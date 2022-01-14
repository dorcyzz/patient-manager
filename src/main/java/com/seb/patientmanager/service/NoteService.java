package com.seb.patientmanager.service;

import com.seb.patientmanager.data.repository.NoteRepository;
import com.seb.patientmanager.data.model.Note;
import java.util.Optional;

public class NoteService {
    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        super();

        this.noteRepository = noteRepository;
    }

    public Note getNote(Integer id) {
        Optional<Note> note = this.noteRepository.findById(id);

        return note.orElse(null);
    }

    public Note saveNote(Note note) {
        return this.noteRepository.save(note);
    }

    public void deleteNote(Integer id) {
        Note note = this.getNote(id);

        if (note != null) {
            this.noteRepository.delete(note);
        }
    }
}
