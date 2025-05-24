package com.techservice.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.techservice.dto.AvisEtudiantRequestDTO;
import com.techservice.dto.AvisResponseDTO;
import com.techservice.dto.UtilisateurDTO;
import com.techservice.model.AvisEtudiant;
import com.techservice.model.BonDeTravail;
import com.techservice.proxies.UtilisateurClient;
import com.techservice.repository.AvisEtudiantRepository;
import com.techservice.repository.BonDeTravailRepository;

@Service 
public class AvisService {
   
    @Autowired
    private AvisEtudiantRepository repository;

    @Autowired
    private BonDeTravailRepository bonDeTravailRepository;
    
    @Autowired
    private UtilisateurClient utilisateurClient;
    
    
    public List<AvisResponseDTO> getAllAvisEnrichis() {
        List<AvisEtudiant> avisList = repository.findAll();

        return avisList.stream().map(avis -> {
            AvisResponseDTO dto = new AvisResponseDTO();
            dto.setIdEtudiant(avis.getIdEtudiant());
            dto.setIdBonDeTravail(avis.getBonDeTravail().getIdBonDeTravail());
            dto.setCommentaire(avis.getCommentaire());

            try {
                UtilisateurDTO utilisateur = utilisateurClient.getUtilisateurById(avis.getIdEtudiant());
                dto.setNomEtudiant(utilisateur.getNom());
                dto.setPrenomEtudiant(utilisateur.getPrenom());
            } catch (Exception e) {
                // En cas d'erreur, on peut laisser le nom/prénom vide ou les remplir par défaut
                dto.setNomEtudiant("Inconnu");
                dto.setPrenomEtudiant("Inconnu");
            }

            return dto;
        }).toList();
    }

    public ResponseEntity<AvisEtudiant> envoyerAvis(AvisEtudiantRequestDTO dto) {
    	BonDeTravail bon = bonDeTravailRepository.findById(dto.getIdBonDeTravail())
    	        .orElseThrow(() -> new RuntimeException("Bon introuvable"));

    	    AvisEtudiant avis = new AvisEtudiant();
    	    avis.setBonDeTravail(bon);
    	    avis.setCommentaire(dto.getCommentaire());
    	    avis.setIdEtudiant(dto.getIdEtudiant());
    	    AvisEtudiant savedAvis = repository.save(avis);
    	    return ResponseEntity.ok(savedAvis);
    }

    public Optional<AvisEtudiant> getAvisByBonId(Integer bonId) {
        return bonDeTravailRepository.findById(bonId)
            .flatMap(repository::findByBonDeTravail);
    }

    public List<AvisEtudiant> getAllAvisByBonId(Integer bonId) {
        return bonDeTravailRepository.findById(bonId)
            .map(repository::findAllByBonDeTravail)
            .orElse(Collections.emptyList());
    }
    public AvisEtudiant enregistrerAvis(AvisEtudiantRequestDTO dto) {
        BonDeTravail bon = bonDeTravailRepository.findById(dto.getIdBonDeTravail())
                        .orElseThrow(() -> new RuntimeException("Bon de travail introuvable"));

        AvisEtudiant avis = new AvisEtudiant();
        avis.setIdEtudiant(dto.getIdEtudiant());
        avis.setCommentaire(dto.getCommentaire());
        avis.setBonDeTravail(bon);

        return repository.save(avis);
    }

}
