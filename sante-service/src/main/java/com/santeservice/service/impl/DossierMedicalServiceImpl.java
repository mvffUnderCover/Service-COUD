package com.santeservice.service.impl;

import com.santeservice.dto.ConsultationDTO;
import com.santeservice.dto.DossierMedicalDTO;
import com.santeservice.dto.HistoriqueConsultationDTO;
import com.santeservice.dto.MesureDTO;
import com.santeservice.dto.UtilisateurDTO;
import com.santeservice.model.Consultation;
import com.santeservice.model.DossierMedical;
import com.santeservice.model.MesuresMedicale;
import com.santeservice.repository.ConsultationRepository;
import com.santeservice.repository.DossierMedicalRepository;
import com.santeservice.repository.MesuresMedicaleRepository;
import com.santeservice.service.DossierMedicalService;
import com.santeservice.exception.ResourceNotFoundException;
import com.santeservice.feign.AuthClient;
import com.santeservice.mapper.DossierMedicalMapper;
import com.santeservice.mapper.MapToEntityToMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DossierMedicalServiceImpl implements DossierMedicalService {

    @Autowired
    private DossierMedicalRepository repository;
    
    @Autowired
    private ConsultationRepository consultationRepository;

    @Autowired
    private MesuresMedicaleRepository mesureRepository;
    
    private final AuthClient authClient;

    public DossierMedicalServiceImpl(AuthClient authClient) {
        this.authClient = authClient;
    }
    
    @Autowired
    private MapToEntityToMap servicemap;

    @Override
    public DossierMedicalDTO create(DossierMedicalDTO dto) {
        String idEtudiant = dto.getNumeroDossier(); // L’ID Étudiant = Numéro Dossier

        // Récupération des infos depuis auth-service
        UtilisateurDTO etudiant = authClient.getUtilisateurById(idEtudiant);

        if (etudiant == null || etudiant.getRole() == null || !etudiant.getRole().equalsIgnoreCase("ETUDIANT")) {
            throw new RuntimeException("Étudiant non trouvé ou rôle invalide");
        }

        // Construction de l’entité
        DossierMedical dossier = new DossierMedical();
        dossier.setNumeroDossier(idEtudiant); // obligatoire puisque pas auto-généré
        dossier.setIdSecretaire(dto.getIdSecretaire());
        dossier.setDateCreation(LocalDate.now());
        dossier.setAntecedent(""); // vide par défaut
        dossier.setGroupeSanguin("");
        dossier.setVaccination("");
        dossier.setConsultations(new ArrayList<>());
        dossier.setMesures(new ArrayList<>());

        // Sauvegarde
        DossierMedical saved = repository.save(dossier);

        // Construction du DTO de réponse
        return DossierMedicalMapper.buildDtoWithEtudiantInfo(saved, etudiant);
    }


    @Override
    public DossierMedicalDTO update(String numeroDossier, DossierMedicalDTO dto) {
        DossierMedical existing = repository.findById(numeroDossier).orElseThrow();
        existing.setAntecedent(dto.getAntecedent());
        existing.setGroupeSanguin(dto.getGroupeSanguin());
        existing.setVaccination(dto.getVaccination());
        return servicemap.toDto(repository.save(existing));
    }

    @Override
    public DossierMedicalDTO getByNumero(String numeroDossier) {
        DossierMedical dossier = repository.findById(numeroDossier)
            .orElseThrow(() -> new RuntimeException("Dossier non trouvé"));

        // Récupération des infos depuis auth-service
        UtilisateurDTO etudiant = authClient.getUtilisateurById(numeroDossier);

        if (etudiant == null || etudiant.getRole() == null || !etudiant.getRole().equalsIgnoreCase("ETUDIANT")) {
            throw new RuntimeException("Étudiant non trouvé ou rôle invalide");
        }

        return DossierMedicalMapper.buildDtoWithEtudiantInfo(dossier, etudiant);
    }


    @Override
    public List<DossierMedicalDTO> getAll() {
        return repository.findAll().stream().map(servicemap::toDto).collect(Collectors.toList());
    }
    
    @Override
    public ConsultationDTO addConsultation(String numeroDossier, ConsultationDTO dto) {
        // On récupère le dossier médical associé
        DossierMedical dossier = repository.findByNumeroDossier(numeroDossier)
            .orElseThrow(() -> new RuntimeException("Dossier médical introuvable avec le numéro : " + numeroDossier));

        // On crée et remplit la consultation
        Consultation consultation = new Consultation();
        consultation.setDossierMedical(dossier);
        consultation.setIdMedecin(dto.getIdMedecin());
        consultation.setDateConsultation(LocalDate.now());
        consultation.setExamens(dto.getExamens());
        consultation.setTraitements(dto.getTraitements());

        // On sauvegarde et met à jour le DTO
        consultation = consultationRepository.save(consultation);
        dto.setIdConsultation(consultation.getIdConsultation());
        dto.setNumeroDossier(numeroDossier); // Facultatif pour retour
        return dto;
    }


    @Override
    public List<ConsultationDTO> getConsultationsByDossier(String numeroDossier) {
        return consultationRepository.findByDossierMedical_NumeroDossier(numeroDossier)
            .stream()
            .map(consultation -> {
                ConsultationDTO dto = new ConsultationDTO();
                dto.setIdConsultation(consultation.getIdConsultation());
                dto.setNumeroDossier(consultation.getDossierMedical().getNumeroDossier());
                dto.setIdMedecin(consultation.getIdMedecin());
                dto.setDateConsultation(consultation.getDateConsultation());
                dto.setExamens(consultation.getExamens());
                dto.setTraitements(consultation.getTraitements());
                return dto;
            }).collect(Collectors.toList());
    }

    @Override
    public ConsultationDTO updateConsultation(String numeroDossier, Integer id, ConsultationDTO dto) {
        DossierMedical dossier = repository.findById(numeroDossier)
            .orElseThrow(() -> new ResourceNotFoundException("Dossier médical introuvable"));

        Consultation consultation = consultationRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Consultation introuvable"));

        if (!consultation.getDossierMedical().getNumeroDossier().equals(numeroDossier)) {
            throw new IllegalStateException("Consultation non liée à ce dossier.");
        }

        consultation.setDateConsultation(LocalDate.now());
        consultation.setExamens(dto.getExamens());
        consultation.setTraitements(dto.getTraitements());
        consultation.setIdMedecin(dto.getIdMedecin());

        consultation = consultationRepository.save(consultation);

        dto.setIdConsultation(consultation.getIdConsultation());
        return dto;
    }


    @Override
    public MesureDTO addMesure(String numeroDossier, MesureDTO dto) {
        DossierMedical dossier = repository.findById(numeroDossier)
            .orElseThrow(() -> new ResourceNotFoundException("Dossier médical introuvable"));

        MesuresMedicale mesure = new MesuresMedicale();
        mesure.setDossierMedical(dossier);
        mesure.setDateMesure(LocalDate.now());
        mesure.setIdMedecin(dto.getIdMedecin());
        mesure.setPoids(dto.getPoids());
        mesure.setTaille(dto.getTaille());
        mesure.setTensionArterielle(dto.getTensionArterielle());
        mesure.setPouls(dto.getPouls());
        mesure = mesureRepository.save(mesure);

        dto.setIdMesure(mesure.getIdMesure());
        dto.setNumeroDossier(numeroDossier);
        return dto;
    }


    @Override
    public List<MesureDTO> getMesuresByDossier(String numeroDossier) {
        return mesureRepository.findByDossierMedical_NumeroDossier(numeroDossier)
            .stream()
            .map(mesure -> {
                MesureDTO dto = new MesureDTO();
                dto.setIdMesure(mesure.getIdMesure());
                dto.setNumeroDossier(mesure.getDossierMedical().getNumeroDossier());
                dto.setDateMesure(mesure.getDateMesure());
                dto.setPoids(mesure.getPoids());
                dto.setTaille(mesure.getTaille());
                dto.setTensionArterielle(mesure.getTensionArterielle());
                dto.setPouls(mesure.getPouls());
                return dto;
            }).collect(Collectors.toList());
    }

    @Override
    public MesureDTO updateMesure(String numeroDossier, Integer id, MesureDTO dto) {
        DossierMedical dossier = repository.findById(numeroDossier)
            .orElseThrow(() -> new ResourceNotFoundException("Dossier médical introuvable"));

        MesuresMedicale mesure = mesureRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Mesure introuvable"));

        // Vérifie que la mesure appartient bien au dossier
        if (!mesure.getDossierMedical().getNumeroDossier().equals(numeroDossier)) {
            throw new IllegalStateException("Mesure non liée à ce dossier médical.");
        }

        mesure.setDateMesure(LocalDate.now());
        mesure.setPoids(dto.getPoids());
        mesure.setTaille(dto.getTaille());
        mesure.setTensionArterielle(dto.getTensionArterielle());
        mesure.setPouls(dto.getPouls());

        mesure = mesureRepository.save(mesure);
        dto.setIdMesure(mesure.getIdMesure());
        return dto;
    }
    
    @Override
    public List<HistoriqueConsultationDTO> getHistoriqueConsultations() {
        List<DossierMedical> dossiers = repository.findAll(); // à adapter si tu veux paginer
        List<HistoriqueConsultationDTO> historique = new ArrayList<>();
        

        for (DossierMedical dossier : dossiers) {
            int total = dossier.getConsultations().size();
            for (Consultation c : dossier.getConsultations()) {
                HistoriqueConsultationDTO dto = new HistoriqueConsultationDTO();
                dto.setNumeroDossier(dossier.getNumeroDossier());
                dto.setDateConsultation(c.getDateConsultation());
                dto.setExamens(c.getExamens());
                dto.setTraitements(c.getTraitements());
                dto.setNombreTotalVisites(total);

                historique.add(dto);
            }
        }
        return historique;
    }


    @Override
    public void delete(String numeroDossier) {
        repository.deleteById(numeroDossier);
    }
}
