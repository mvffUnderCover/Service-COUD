package com.utilisateurs.authservice.util;

import java.util.Optional;

import com.utilisateurs.authservice.dto.EtudiantDTO;
import com.utilisateurs.authservice.dto.UtilisateurDto;
import com.utilisateurs.authservice.model.Utilisateur;

public class ServiceMap {

    public static UtilisateurDto mapToDto(Utilisateur utilisateur) {
        UtilisateurDto dto = new UtilisateurDto();
        dto.setImmatricul(utilisateur.getImmatricul());
        dto.setNom(utilisateur.getNom());
        dto.setPrenom(utilisateur.getPrenom());
        dto.setEmail(utilisateur.getEmail());
        dto.setIdSection(utilisateur.getIdSection());
        dto.setRole(utilisateur.getRole()); 
        return dto;
    }

    public static EtudiantDTO mapEtudiantToUtilisateurDTO(EtudiantDTO etudiant) {
        EtudiantDTO dto = new EtudiantDTO();
        dto.setNumcarte(etudiant.getNumcarte()); // ⚠️ manquant
        dto.setNom(etudiant.getNom());
        dto.setPrenom(etudiant.getPrenom());
        dto.setFaculte(etudiant.getFaculte());
        dto.setDateLieuNaissance(etudiant.getDateLieuNaissance());
        dto.setSituationFamiliale(etudiant.getSituationFamiliale());
        dto.setNombreEnfants(etudiant.getNombreEnfants());
        dto.setNiveauEtude(etudiant.getNiveauEtude());
        dto.setEmail(etudiant.getEmail()); // ⚠️ manquant
        return dto;
    }


}

