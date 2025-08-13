package com.example.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.model.Tag;
import com.example.ecommerce.service.TagService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/tags")
public class TagController {

    @Autowired
    private TagService tagService;

    @PostMapping
    public Tag create(@Valid @RequestBody Tag tag) {
        return tagService.create(tag);
    }

    @GetMapping
    public List<Tag> getAll() {
        return tagService.getAll();
    }
}
