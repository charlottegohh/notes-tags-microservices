package com.example.tags.controller;

import com.example.tags.model.Tag;
import com.example.tags.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tags")
@RequiredArgsConstructor
public class TagController {
    private final TagService tagService;

    @GetMapping
    public List<Tag> getAll() {
        return tagService.getAlltags();
    }

    @GetMapping("/{id}")
    public Tag getById(@PathVariable Long id){
        return tagService.getTagById(id);
    }

    @PostMapping
    public Tag create(@RequestBody Tag tag) {
        return tagService.createtag(tag);
    }
}