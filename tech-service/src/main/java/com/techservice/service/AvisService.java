package com.techservice.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techservice.dto.AvisEtudiantRequestDTO;
import com.techservice.model.AvisEtudiant;
import com.techservice.model.BonDeTravail;
import com.techservice.repository.AvisEtudiantRepository;
import com.techservice.repository.BonDeTravailRepository;

@Service 
public class AvisService {
   
    @Autowired
    private AvisEtudiantRepository repository;

    @Autowired
    private BonDeTravailRepository bonDeTravailRepository;

    public AvisEtudiant envoyerAvis(AvisEtudiant avis) {
        return repository.save(avis);
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
        avis.setNote(dto.getNote());
        avis.setBonDeTravail(bon);

        return repository.save(avis);
    }

}
