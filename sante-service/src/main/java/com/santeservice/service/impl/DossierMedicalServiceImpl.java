package com.santeservice.service.impl;

import com.santeservice.dto.ConsultationDTO;
import com.santeservice.dto.DossierMedicalDTO;
import com.santeservice.dto.MesureDTO;
import com.santeservice.model.Consultation;
import com.santeservice.model.DossierMedical;
import com.santeservice.model.MesuresMedicale;
import com.santeservice.repository.ConsultationRepository;
import com.santeservice.repository.DossierMedicalRepository;
import com.santeservice.repository.MesuresMedicaleRepository;
import com.santeservice.service.DossierMedicalService;
import com.santeservice.exception.ResourceNotFoundException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


    private DossierMedicalDTO toDto(DossierMedical entity) {
        DossierMedicalDTO dto = new DossierMedicalDTO();
        dto.setNumeroDossier(entity.getNumeroDossier());
        dto.setIdEtudiant(entity.getIdEtudiant());
        dto.setIdSecretaire(entity.getIdSecretaire());
        dto.setAntecedent(entity.getAntecedent());
        dto.setGroupeSanguin(entity.getGroupeSanguin());
        dto.setVaccination(entity.getVaccination());
        return dto;
    }

    private DossierMedical toEntity(DossierMedicalDTO dto) {
        DossierMedical entity = new DossierMedical();
        entity.setNumeroDossier(dto.getNumeroDossier());
        entity.setIdEtudiant(dto.getIdEtudiant());
        entity.setIdSecretaire(dto.getIdSecretaire());
        entity.setAntecedent(dto.getAntecedent());
        entity.setGroupeSanguin(dto.getGroupeSanguin());
        entity.setVaccination(dto.getVaccination());
        return entity;
    }

    @Override
    public DossierMedicalDTO create(DossierMedicalDTO dto) {
        return toDto(repository.save(toEntity(dto)));
    }

    @Override
    public DossierMedicalDTO update(String numeroDossier, DossierMedicalDTO dto) {
        DossierMedical existing = repository.findById(numeroDossier).orElseThrow();
        existing.setAntecedent(dto.getAntecedent());
        existing.setVaccination(dto.getVaccination());
        return toDto(repository.save(existing));
    }

    @Override
    public DossierMedicalDTO getByNumero(String numeroDossier) {
        return toDto(repository.findById(numeroDossier).orElseThrow());
    }

    @Override
    public List<DossierMedicalDTO> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
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
        consultation.setDateConsultation(dto.getDateConsultation());
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

        consultation.setDateConsultation(dto.getDateConsultation());
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
        mesure.setDateMesure(dto.getDateMesure());
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

        mesure.setDateMesure(dto.getDateMesure());
        mesure.setPoids(dto.getPoids());
        mesure.setTaille(dto.getTaille());
        mesure.setTensionArterielle(dto.getTensionArterielle());
        mesure.setPouls(dto.getPouls());

        mesure = mesureRepository.save(mesure);
        dto.setIdMesure(mesure.getIdMesure());
        return dto;
    }


    @Override
    public void delete(String numeroDossier) {
        repository.deleteById(numeroDossier);
    }
}
