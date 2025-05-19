package com.santeservice.mapper;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.santeservice.dto.DossierMedicalDTO;
import com.santeservice.dto.UtilisateurDTO;
import com.santeservice.model.DossierMedical;

@Component
public class DossierMedicalMapper {

    public static DossierMedicalDTO buildDtoWithEtudiantInfo(DossierMedical entity, UtilisateurDTO etudiant) {
        DossierMedicalDTO dto = new DossierMedicalDTO();

        // Depuis l'entité
        dto.setNumeroDossier(entity.getNumeroDossier());
        dto.setDateCreationDossier(entity.getDateCreation());
        dto.setIdSecretaire(entity.getIdSecretaire());
        dto.setAntecedent(entity.getAntecedent());
        dto.setGroupeSanguin(entity.getGroupeSanguin());
        dto.setVaccination(entity.getVaccination());
        // ... autres champs si nécessaires

        // Depuis le DTO étudiant (infos récupérées via auth-service)
        dto.setNom(etudiant.getNom());
        dto.setPrenom(etudiant.getPrenom());
        dto.setNiveauEtude(etudiant.getNiveauEtude());
        dto.setDateLieuNaissance(etudiant.getDateLieuNaissance());
        dto.setSituationFamiliale(etudiant.getSituationFamiliale());
        dto.setNombreEnfants(etudiant.getNombreEnfants());
        
        dto.setConsultations(
        	    entity.getConsultations().stream()
        	          .map(ConsultationMapper::toDto)
        	          .collect(Collectors.toList())
        	);

        	dto.setMesures(
        	    entity.getMesures().stream()
        	          .map(MesureMapper::toDto)
        	          .collect(Collectors.toList())
        	);

        return dto;
    }
}