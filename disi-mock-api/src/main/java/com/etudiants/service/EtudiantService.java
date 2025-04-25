package com.etudiants.service;

import com.etudiants.model.Etudiant;
import com.etudiants.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EtudiantService {

    @Autowired
    private EtudiantRepository repository;

    // CREATE
    public Etudiant ajouterEtudiant(Etudiant etudiant) {
        return repository.save(etudiant);
    }

    // READ - tous les étudiants
    public List<Etudiant> listerEtudiants() {
        return repository.findAll();
    }

    // READ - par carte
    public Optional<Etudiant> chercherParNumCarte(String numcarte) { 
        return repository.findById(numcarte);
    }

    // READ - par email
    public Optional<Etudiant> chercherParEmail(String email) {
        return repository.findByEmail(email);
    }

 // UPDATE 
    public Etudiant modifierEtudiant(String numcarte, Etudiant etudiantModifie) {
        return repository.findById(numcarte)
                .map(e -> {
                    e.setPrenom(etudiantModifie.getPrenom());
                    e.setNom(etudiantModifie.getNom());
                    e.setEmail(etudiantModifie.getEmail());
                    e.setTelephone(etudiantModifie.getTelephone());
                    e.setFaculte(etudiantModifie.getFaculte());

                    // Nouveaux champs ajoutés
                    e.setDateLieuNaissance(etudiantModifie.getDateLieuNaissance());
                    e.setSituationFamiliale(etudiantModifie.getSituationFamiliale());
                    e.setNombreEnfants(etudiantModifie.getNombreEnfants());
                    e.setNiveauEtude(etudiantModifie.getNiveauEtude());

                    return repository.save(e);
                })
                .orElseThrow(() -> new RuntimeException("Étudiant non trouvé"));
    }
    
    public boolean validateEtudiant(String email, String numcarte) {
        Optional<Etudiant> etudiant = repository.findByEmailAndNumcarte(email, numcarte);
        return etudiant.isPresent();
    }

    // DELETE
    public void supprimerEtudiant(String numcarte) {
        repository.deleteById(numcarte);
    }
}
