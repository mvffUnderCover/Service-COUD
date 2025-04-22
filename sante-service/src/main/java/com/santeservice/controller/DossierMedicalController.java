package com.santeservice.controller;

import com.santeservice.dto.ConsultationDTO;
import com.santeservice.dto.DossierMedicalDTO;
import com.santeservice.dto.MesureDTO;
import com.santeservice.service.DossierMedicalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
                                  
@RestController
@RequestMapping("/api/sante")
@CrossOrigin(origins = "*")
public class DossierMedicalController {

    private final DossierMedicalService dossierMedicalService;

    public DossierMedicalController(DossierMedicalService dossierMedicalService) {
        this.dossierMedicalService = dossierMedicalService;
    }

    // ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
    // ░░ GESTION DOSSIER
    // ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓

    @PostMapping("/dossiers")
    public ResponseEntity<DossierMedicalDTO> createDossier(@RequestBody DossierMedicalDTO dto) {
        return ResponseEntity.ok(dossierMedicalService.create(dto));
    }

    @PutMapping("/dossiers/{numero}")
    public ResponseEntity<DossierMedicalDTO> updateDossier(
            @PathVariable String numero,
            @RequestBody DossierMedicalDTO dto) {
        return ResponseEntity.ok(dossierMedicalService.update(numero, dto));
    }

    @GetMapping("/dossiers/{numero}")
    public ResponseEntity<DossierMedicalDTO> getDossier(@PathVariable String numero) {
        return ResponseEntity.ok(dossierMedicalService.getByNumero(numero));
    }

    // ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
    // ░░ MESURES MÉDICALES
    // ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓

    @PostMapping("/dossiers/{numero}/mesures")
    public ResponseEntity<MesureDTO> addMesure(
            @PathVariable String numero,
            @RequestBody MesureDTO dto) {
        return ResponseEntity.ok(dossierMedicalService.addMesure(numero, dto));
    }

    @GetMapping("/dossiers/{numero}/mesures")
    public ResponseEntity<List<MesureDTO>> getMesures(@PathVariable String numero) {
        return ResponseEntity.ok(dossierMedicalService.getMesuresByDossier(numero));
    }
    @PutMapping("/dossiers/{numero}/mesures/{id}")
    public ResponseEntity<MesureDTO> updateMesure(
            @PathVariable String numero,
            @PathVariable Integer id,
            @RequestBody MesureDTO dto) {
        return ResponseEntity.ok(dossierMedicalService.updateMesure(numero, id, dto));
    }


    // ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
    // ░░ CONSULTATIONS
    // ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓

    @PostMapping("/dossiers/{numero}/consultations")
    public ResponseEntity<ConsultationDTO> addConsultation(
            @PathVariable String numero,
            @RequestBody ConsultationDTO dto) {
        return ResponseEntity.ok(dossierMedicalService.addConsultation(numero, dto));
    }

    @GetMapping("/dossiers/{numero}/consultations")
    public ResponseEntity<List<ConsultationDTO>> getConsultations(@PathVariable String numero) {
        return ResponseEntity.ok(dossierMedicalService.getConsultationsByDossier(numero));
    }
    @PutMapping("/dossiers/{numero}/consultations/{id}")
    public ResponseEntity<ConsultationDTO> updateConsultation(
            @PathVariable String numero,
            @PathVariable Integer id,
            @RequestBody ConsultationDTO dto) {
        return ResponseEntity.ok(dossierMedicalService.updateConsultation(numero, id, dto));
    }

}
