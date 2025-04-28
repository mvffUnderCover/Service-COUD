package com.techservice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PatchMapping;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techservice.model.DemandeDepannage;
import com.techservice.service.DemandeDepannageService;

@RestController
@RequestMapping("/tech/demandes")
public class DemandeDepannageController {

    @Autowired
    private DemandeDepannageService service;

    @GetMapping
    public List<DemandeDepannage> getAll() {
        return service.getAllDemandes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DemandeDepannage> getById(@PathVariable Integer id) {
        return service.getById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public DemandeDepannage create(@RequestBody DemandeDepannage demande) {
        return service.createDemande(demande);
    }

    @PutMapping("/{id}")
    public DemandeDepannage update(@PathVariable Integer id, @RequestBody DemandeDepannage demande) {
        return service.updateDemande(id, demande);
    }
    
    @PatchMapping("/{id}/statut")
    public ResponseEntity<DemandeDepannage> updateStatut(@PathVariable Integer id, @RequestBody Map<String, String> body) {
        String nouveauStatut = body.get("statut");
        DemandeDepannage updated = service.updateStatut(id, nouveauStatut);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        service.deleteDemande(id);
        return ResponseEntity.ok().build();
    }
}

