package com.example.Notes.service;

import com.example.Notes.model.Note;
import com.example.Notes.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService {
    private final NoteRepository noteRepository;
    private final RestTemplate restTemplate;

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public Note createNote(Note note) {
        if(note.getTagId() != null){
            String TagServiceUrl = "http://localhost:8081/api/tags/" + note.getTagId();
            restTemplate.getForObject(TagServiceUrl, Object.class);
        }
        return noteRepository.save(note);
    }
}