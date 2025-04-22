package com.techservice.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techservice.dto.*;
import com.techservice.model.BonDeTravail;
import com.techservice.model.DemandeDepannage;
import com.techservice.model.Section;
import com.techservice.proxies.UtilisateurClient;
import com.techservice.repository.AvisEtudiantRepository;
import com.techservice.repository.BonDeTravailRepository;
import com.techservice.repository.DemandeDepannageRepository;
import com.techservice.repository.SectionRepository;

@Service
public class BonDeTravailService {

    @Autowired
    private UtilisateurClient utilisateurClient;

    @Autowired
    private DemandeDepannageRepository demandeRepo;

    @Autowired
    private final AvisEtudiantRepository avisEtudiantRepository;

    @Autowired
    private BonDeTravailRepository repository;

    @Autowired
    private SectionRepository sectionRepository;

    BonDeTravailService(AvisEtudiantRepository avisEtudiantRepository) {
        this.avisEtudiantRepository = avisEtudiantRepository;
    }

    public List<BonDeTravail> getAll() {
        return repository.findAll();
    }

    public Optional<BonDeTravail> getById(Integer id) {
        return repository.findById(id);
    }

    // ✅ Création du bon de travail par chef de résidence
    public BonDeTravail creerBon(Integer demandeId, String idChefResidence, String descriptionTravail, String lieuIntervention) {
        UtilisateurDTO chef = utilisateurClient.getUtilisateurById(idChefResidence);

        DemandeDepannage demande = demandeRepo.findById(demandeId)
            .orElseThrow(() -> new RuntimeException("Demande non trouvée"));

        if (!"Traité".equalsIgnoreCase(demande.getStatu())) {
            throw new RuntimeException("La demande doit être acceptée avant de créer un bon.");
        }

        BonDeTravail bon = new BonDeTravail();
        bon.setDemande(demande);
        bon.setEtat("Crée");
        bon.setIdChefDeResidence(idChefResidence);
        bon.setDescriptionTravail(descriptionTravail);
        bon.setLieuIntervention(lieuIntervention);
        bon.setCreePar(chef.getPrenom() + " " + chef.getNom());
        bon.setDateCreation(LocalDate.now());

        return repository.save(bon);
    }


    // ✅ Affecter une section au bon
    public BonDeTravail affecterSection(Integer bonId, Integer idSection) {
        BonDeTravail bon = repository.findById(bonId)
            .orElseThrow(() -> new RuntimeException("Bon non trouvé"));

        Section section = sectionRepository.findById(idSection)
            .orElseThrow(() -> new RuntimeException("Section non trouvée"));

        bon.setSection(section);
        bon.setEtat("En attente");
        bon.setDateIntervention(LocalDate.now());
     
        return repository.save(bon);
    }

    // ✅ Affecter un ouvrier et le matériel utilisé
    public BonDeTravail affecterOuvrierEtMateriel(Integer bonId, String idOuvrier, String materiel) {
        BonDeTravail bon = repository.findById(bonId)
            .orElseThrow(() -> new RuntimeException("Bon non trouvé"));

        bon.setIdOuvrier(idOuvrier);
        bon.setMaterielConsomme(materiel);
        bon.setEtat("EN COURS");

        return repository.save(bon);
    }
    public BonDeTravail marquerCommeExecute(Integer idBon) {
        BonDeTravail bon = repository.findById(idBon)
            .orElseThrow(() -> new RuntimeException("Bon non trouvé"));

        bon.setEtat("EXÉCUTÉ");
        return repository.save(bon);
    }

    // ✅ Clôturer le bon
    public BonDeTravail cloturerBon(Integer idBon) {
        BonDeTravail bon = repository.findById(idBon)
            .orElseThrow(() -> new RuntimeException("Bon non trouvé"));

        if (!"EXÉCUTÉ".equals(bon.getEtat())) {
            throw new RuntimeException("Le bon ne peut être clôturé que s'il est en état 'EXÉCUTÉ'");
        }

        bon.setEtat("CLÔTURÉ");
        bon.setDateCloture(LocalDate.now());

        return repository.save(bon);
    }

    

}
