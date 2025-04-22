package com.utilisateurs.authservice.controller;


import com.utilisateurs.authservice.dto.UpdateEmployeRequest;
import com.utilisateurs.authservice.dto.UpdatePasswordRequest;
import com.utilisateurs.authservice.model.Utilisateur;
import com.utilisateurs.authservice.service.UtilisateurService;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateurController {
  
    @Autowired
    private UtilisateurService utilisateurService;

    // 1. Lister tous les employés
    @GetMapping
    public List<Utilisateur> getAllEmployes() {
        return utilisateurService.getAllEmployes();
    }

    // Rechercher un employé par immatricul
    @GetMapping("/{immatricul}")
    public ResponseEntity<Optional<Utilisateur>> getEmploye(@PathVariable String immatricul) {
        try {
            Optional<Utilisateur> employe = utilisateurService.getEmployeByImmatricul(immatricul);
            return ResponseEntity.ok(employe);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Ajouter un employé
    @PostMapping("/add/{roleId}")
    public ResponseEntity<Utilisateur> addEmploye(@RequestBody Utilisateur utilisateur,
                                                  @PathVariable int roleId) {
        try {
            Utilisateur newEmploye = utilisateurService.addEmploye(utilisateur, roleId);
            return ResponseEntity.ok(newEmploye);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // Modifier un employé
    @PutMapping("/update/{immatricul}")
    public ResponseEntity<Utilisateur> updateEmploye(@PathVariable String immatricul,
    		                                         @RequestBody UpdateEmployeRequest request) {
        
            Utilisateur updated = utilisateurService.updateEmploye(immatricul, request);
            return ResponseEntity.ok(updated);
    }
    @PutMapping("/{immatricul}/motdepasse")
    public ResponseEntity<?> updatePassword(@PathVariable String immatricul, @RequestBody UpdatePasswordRequest request) {

        try {
            utilisateurService.updatePassword(immatricul, request);
            return ResponseEntity.ok("Mot de passe mis à jour avec succès.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Erreur lors de la mise à jour du mot de passe.");
        }
    }

    // 5. Supprimer un employé
    @DeleteMapping("/delete/{immatricul}")
    public ResponseEntity<Void> deleteEmploye(@PathVariable String immatricul) {
        try {
            utilisateurService.deleteEmploye(immatricul);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
