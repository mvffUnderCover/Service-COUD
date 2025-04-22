package com.techservice.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techservice.model.DemandeDepannage;
import com.techservice.repository.DemandeDepannageRepository;

@Service
public class DemandeDepannageService {

    @Autowired
    private DemandeDepannageRepository repository;

    public List<DemandeDepannage> getAllDemandes() {
        return repository.findAll();
    }

    public Optional<DemandeDepannage> getById(Integer id) {
        return repository.findById(id);
    }

    public DemandeDepannage createDemande(DemandeDepannage demande) {
        demande.setDateSoumission(LocalDate.now()); // auto set
        return repository.save(demande);
    }

    public DemandeDepannage updateDemande(Integer id, DemandeDepannage updated) {
        return repository.findById(id).map(demande -> {
            demande.setDescription(updated.getDescription());
            demande.setStatu(updated.getStatu());
            return repository.save(demande);
        }).orElseThrow(() -> new RuntimeException("Demande non trouvée"));
    }
    
    public DemandeDepannage updateStatut(Integer id, String statut) {
        Optional<DemandeDepannage> optionalDemande = repository.findById(id);
        if (optionalDemande.isPresent()) {
            DemandeDepannage demande = optionalDemande.get();
            demande.setStatu(statut); // N'oublie pas que c'est bien `statu` dans ton entité
            return repository.save(demande);
        }
        return null;
    }


    public void deleteDemande(Integer id) {
        repository.deleteById(id);
    }
}

