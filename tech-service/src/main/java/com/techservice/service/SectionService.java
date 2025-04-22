package com.techservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techservice.model.Section;
import com.techservice.repository.SectionRepository;
import java.util.Optional;

@Service
public class SectionService {

    @Autowired
    private SectionRepository repository;

    // READ all
    public List<Section> getAll() {
        return repository.findAll();
    }

    // READ by id
    public Optional<Section> getById(Integer id) {
        return repository.findById(id);
    }

    // CREATE
    public Section createSection(Section section) {
        return repository.save(section);
    }

    
    // DELETE
    public void deleteSection(Integer id) {
        repository.deleteById(id);
    }
}