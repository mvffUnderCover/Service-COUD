package com.techservice.controller;


import com.techservice.dto.*;

import com.techservice.model.BonDeTravail;
import com.techservice.service.BonDeTravailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bons-travail")
public class BonDeTravailController {

    @Autowired
    private BonDeTravailService service;
    
    @Autowired
    private BonDeTravailMapper mapper;

    @GetMapping
    public List<BonDeTravail> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BonDeTravail> getById(@PathVariable Integer id) {
        return service.getById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    // ✅ Création de bon avec BonDeTravailRequest (idDemande, idChefDeResidence)
    @PostMapping("/creer")
    public ResponseEntity<BonDeTravail> creerBon(@RequestBody BonDeTravailRequest request) {
        BonDeTravail bon = service.creerBon(
            request.getIdDemande(),
            request.getIdChefDeResidence(),
            request.getDescriptionTravail(),
            request.getLieuIntervention()
        );
        return new ResponseEntity<>(bon, HttpStatus.CREATED);
    }

 // ✅ PATCH = mise à jour partielle
    @PatchMapping("/affecter-section")
    public ResponseEntity<BonDeTravailResponseDTO> affecterSection(@RequestBody BonDeTravailRequest request) {
        try {
            BonDeTravail bon = service.affecterSection(request.getIdBon(), request.getIdSection());
            return ResponseEntity.ok(mapper.mapToDto(bon));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/affectation")
    public ResponseEntity<BonDeTravailResponseDTO> affecterOuvrierEtMateriel(@RequestBody AffectationBonRequestDTO request) {
        try {
            BonDeTravail bon = service.affecterOuvrierEtMateriel(
                request.getIdBon(),
                request.getIdOuvrier(),
                request.getMaterielConsomme()
            ); 
            return ResponseEntity.ok(mapper.mapToResponseDTO(bon));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PatchMapping("/{id}/terminer")
    public ResponseEntity<BonDeTravailResponseDTO> marquerCommeExecute(@PathVariable Integer id) {
        try {
            BonDeTravail bon = service.marquerCommeExecute(id);
            return ResponseEntity.ok(mapper.mapToResponseDTO(bon));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }


    // ✅ Clôturer bon
    @PatchMapping("/cloturer/{idBon}")
    public ResponseEntity<BonDeTravailResponseDTO> cloturerBon(@PathVariable Integer idBon) {
        try {
            BonDeTravail bon = service.cloturerBon(idBon);
            return ResponseEntity.ok(mapper.mapToResponseClotureDTO(bon));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
