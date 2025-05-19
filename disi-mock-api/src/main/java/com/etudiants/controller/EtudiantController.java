package com.etudiants.controller;

import com.etudiants.model.Etudiant;
import com.etudiants.repository.EtudiantRepository;
import com.etudiants.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/disi")
public class EtudiantController {

    @Autowired
    private EtudiantService service;
    
    @Autowired
    private EtudiantRepository etudiantRepository;

    // GET ALL
    @GetMapping("/etudiants")
    public List<Etudiant> getAll() {
        return service.listerEtudiants();
    }

    // GET by numcarte
    @GetMapping("/etudiants/{numcarte}")
    public Optional<Etudiant> getByNumCarte(@PathVariable String numcarte) {
        return service.chercherParNumCarte(numcarte);
    }

    // GET by email
    @GetMapping("/etudiants/email/{email}")
    public Optional<Etudiant> getByEmail(@PathVariable String email) {
        return service.chercherParEmail(email);
    }

    // CREATE
    @PostMapping
    public Etudiant create(@RequestBody Etudiant etudiant) {
        return service.ajouterEtudiant(etudiant);
    }
    
    @PostMapping("/validate")
    public boolean validateEtudiant(@RequestParam String email, @RequestParam String numcarte) {
        Optional<Etudiant> etudiant = etudiantRepository.findByEmailAndNumcarte(email, numcarte);
        return etudiant.isPresent();
    }

    // UPDATE
    @PutMapping("/etudiants/{numcarte}")
    public Etudiant update(@PathVariable String numcarte, @RequestBody Etudiant etudiant) {
        return service.modifierEtudiant(numcarte, etudiant);
    }

    // DELETE
    @DeleteMapping("/{numcarte}")
    public void delete(@PathVariable String numcarte) {
        service.supprimerEtudiant(numcarte);
    }
}
