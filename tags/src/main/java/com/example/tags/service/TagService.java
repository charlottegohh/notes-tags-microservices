package com.example.tags.service;

import com.example.tags.model.Tag;
import com.example.tags.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagService {
    private final TagRepository tagRepository;

    public List<Tag> getAlltags() {
        return tagRepository.findAll();
    }

    public Tag createtag(Tag tag) {
        return tagRepository.save(tag);
    }

    public Tag getTagById(Long id){
        return tagRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Tag not found with id " + id));
    }
}