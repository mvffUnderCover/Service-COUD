package com.techservice.controller;

import com.techservice.model.Section;
import com.techservice.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tech/sections")
public class SectionController {

    @Autowired
    private SectionService service;

    //GET ALL
    @GetMapping
    public List<Section> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Section> getById(@PathVariable Integer id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //POST - Create
    @PostMapping
    public ResponseEntity<Section> create(@RequestBody Section section) {
        return ResponseEntity.ok(service.createSection(section));
    }
    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.deleteSection(id);
        return ResponseEntity.noContent().build();
    }
}
