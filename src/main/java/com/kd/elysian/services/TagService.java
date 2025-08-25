package com.kd.elysian.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kd.elysian.models.Tag;
import com.kd.elysian.repositories.TagRepository;

@Service
public class TagService {
    
    private final TagRepository tagRepository;

    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }

    public Tag getTagById(Integer id) {
        return tagRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Tag with ID " + id + " does not exist."));
    }

    public Tag addTag(Tag tag) {
        return tagRepository.save(tag);
    }

    public Tag deleteTag(Integer id) {
        Tag tag = tagRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Tag with ID " + id + " does not exist."));
        tagRepository.delete(tag);
        return tag;
    }
}
