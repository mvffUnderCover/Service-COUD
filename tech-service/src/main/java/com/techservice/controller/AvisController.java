package com.techservice.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techservice.dto.AvisEtudiantRequestDTO;
import com.techservice.dto.AvisResponseDTO;
import com.techservice.model.AvisEtudiant;
import com.techservice.service.AvisService;


@RestController
@RequestMapping("/tech")
public class AvisController {

    @Autowired
    private AvisService service;
    
    @GetMapping("/avis")
    public ResponseEntity<List<AvisResponseDTO>> getAllAvisEnrichis() {
        List<AvisResponseDTO> avisDTOs = service.getAllAvisEnrichis();
        if (avisDTOs.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(avisDTOs);
    }


    @PostMapping("/avis/envoyer")
    public ResponseEntity<AvisEtudiant> envoyer(@RequestBody AvisEtudiantRequestDTO avis) {
        return service.envoyerAvis(avis);
    }

    @GetMapping("/bons/{bonId}")
    public ResponseEntity<List<AvisEtudiant>> retourneLesAvis(@PathVariable Integer bonId) {
        List<AvisEtudiant> avisList = service.getAllAvisByBonId(bonId);
        if (avisList.isEmpty()) {
            return ResponseEntity.noContent().build(); // 204 No Content si aucun avis
        }
        return ResponseEntity.ok(avisList); // 200 OK avec la liste
    }

    // Récupère un seul avis lié à un bon de travail
    @GetMapping("/bon/{bonId}")
    public ResponseEntity<AvisEtudiant> retourneAvis(@PathVariable Integer bonId) {
        return service.getAvisByBonId(bonId)
                .map(ResponseEntity::ok) // 200 OK avec l'avis
                .orElse(ResponseEntity.notFound().build()); // 404 Not Found si absent
    }
    @PostMapping("/avis/ajouter")
    public ResponseEntity<AvisEtudiant> ajouterAvis(@RequestBody AvisEtudiantRequestDTO dto) {
        AvisEtudiant avis = service.enregistrerAvis(dto);
        return ResponseEntity.ok(avis);
    }

}
