package com.utilisateurs.authservice.service;

import com.utilisateurs.authservice.dto.EtudiantDTO;
import com.utilisateurs.authservice.dto.UpdateEmployeRequest;
import com.utilisateurs.authservice.dto.UpdatePasswordRequest;
import com.utilisateurs.authservice.dto.UtilisateurCommunDTO;
import com.utilisateurs.authservice.dto.UtilisateurDto;
import com.utilisateurs.authservice.feign.DisiClient;
import com.utilisateurs.authservice.model.*;
import com.utilisateurs.authservice.repository.*;
import com.utilisateurs.authservice.util.ServiceMap;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private AuthentificationRepository authentificationRepository;
    
    @Autowired
    private DisiClient disiMockClient;

    // 1. Lister tous les employés
    public List<Utilisateur> getAllEmployes() {
        return utilisateurRepository.findAll();
    }

    // 2. Rechercher un employé ou un étudiant par immatricul
    public Optional<UtilisateurCommunDTO> getUtilisateurByImmatricul(String immatricul) {
        if (Character.isLetter(immatricul.charAt(0))) {
            // Employé
            return utilisateurRepository.findById(immatricul)
                    .map(ServiceMap::mapToDto);
        } else {
            // Étudiant
            EtudiantDTO etudiant = disiMockClient.getByNumCarte(immatricul);
            return Optional.ofNullable(etudiant);
        }
    }


    // 3. Ajouter un utilisateur employé + création automatique Authentification
    public Utilisateur addEmploye(Utilisateur utilisateur, int idRole) {
        // Vérifier si l'utilisateur existe déjà
        if (utilisateurRepository.existsById(utilisateur.getImmatricul())) {
            throw new IllegalArgumentException("Un utilisateur avec l'immatricul " + utilisateur.getImmatricul() + " existe déjà.");
        }

        Role role = roleRepository.findById(idRole)
                .orElseThrow(() -> new EntityNotFoundException("Rôle introuvable : " + idRole));

        utilisateur.setRole(role);
        Utilisateur savedUser = utilisateurRepository.save(utilisateur);

        // Création de l'authentification uniquement si elle n'existe pas
        if (!authentificationRepository.existsByUtilisateurImmatricul(utilisateur.getImmatricul())) {
            Authentification auth = new Authentification();
            auth.setUtilisateur(savedUser);
            auth.setPassword("passer123");
            auth.setDateExpiration(LocalDateTime.now().plusDays(1));
            authentificationRepository.save(auth);
        }

        return savedUser;
    }
    
    public List<Utilisateur> getUtilisateursByRoleId(int roleId) {
        return utilisateurRepository.findByRoleId(roleId);
    }



    // 4. Modifier un utilisateur existant
    public Utilisateur updateEmploye(String immatricul, UpdateEmployeRequest request) {
        Utilisateur user = utilisateurRepository.findById(immatricul)
                .orElseThrow(() -> new EntityNotFoundException("Utilisateur non trouvé"));

        Role role = roleRepository.findById(request.getRole_id())
                .orElseThrow(() -> new EntityNotFoundException("Rôle introuvable : " + request.getRole_id()));

        user.setNom(request.getNom());
        user.setPrenom(request.getPrenom());
        user.setTelephone(request.getTelephone());
        user.setDepartement(request.getDepartement());
        user.setIdSection(request.getIdSection());
        user.setRole(role);

        Authentification auth = user.getAuthentification();

        if (auth == null) {
            // 🚨 Pas encore d'authentification -> on en crée une
            auth = new Authentification();
            auth.setUtilisateur(user);
            auth.setPassword("passer123"); // mot de passe par défaut
            auth.setDateExpiration(LocalDateTime.now().plusDays(1));
            authentificationRepository.save(auth);
        } else if (request.getPassword() != null && !request.getPassword().isBlank()) {
            // ✅ Authentification déjà existante, mise à jour du mot de passe si fourni
            auth.setPassword(request.getPassword());
            authentificationRepository.save(auth);
        }

        return utilisateurRepository.save(user);
    }

    public void updatePassword(String immatricul, UpdatePasswordRequest request) {
        Utilisateur user = utilisateurRepository.findById(immatricul)
                .orElseThrow(() -> new EntityNotFoundException("Utilisateur non trouvé"));

        Authentification auth = user.getAuthentification();
        if (auth == null) {
            throw new EntityNotFoundException("Authentification non trouvée pour l'utilisateur");
        }

        // Vérifie l’ancien mot de passe
        if (!auth.getPassword().equals(request.getAncienPassword())) {
            throw new IllegalArgumentException("Ancien mot de passe incorrect");
        }

        auth.setPassword(request.getNouveauPassword());
        authentificationRepository.save(auth);
    }


    // 5. Supprimer un employé
    public void deleteEmploye(String immatricul) {
        if (!utilisateurRepository.existsById(immatricul)) {
            throw new EntityNotFoundException("Utilisateur non trouvé avec l'immatricul : " + immatricul);
        }
        utilisateurRepository.deleteById(immatricul);
    }
}
