package com.seb.patientmanager.rest.controller;

import com.seb.patientmanager.data.model.Note;
import com.seb.patientmanager.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/note")
@CrossOrigin
public class NoteRestController {
    private final NoteService noteService;

    public NoteRestController(@Autowired NoteService noteService) {
        super();

        this.noteService = noteService;
    }

    @GetMapping
    public Note getNote(@RequestParam Integer id) {
        return this.noteService.getNote(id);
    }

    @PostMapping
    public Note createNote(@RequestBody Note note) {
        return this.noteService.saveNote(note);
    }

    @PutMapping
    public Note updateNote(@RequestBody Note note) {
        return this.noteService.saveNote(note);
    }

    @DeleteMapping
    public void deleteNote(@RequestParam Integer id) {
        this.noteService.deleteNote(id);
    }
}
