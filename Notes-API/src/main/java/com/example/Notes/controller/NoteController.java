package com.example.Notes.controller;

import com.example.Notes.model.Note;
import com.example.Notes.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
@RequiredArgsConstructor
public class NoteController {
    private final NoteService noteService;

    @GetMapping
    public List<Note> getAll() {
        return noteService.getAllNotes();
    }

    @PostMapping
    public Note create(@RequestBody Note note) {
        return noteService.createNote(note);
    }
}