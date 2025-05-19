package com.utilisateurs.authservice.service;

import com.utilisateurs.authservice.dto.EtudiantLoginRequest;
import com.utilisateurs.authservice.dto.LoginRequest;
import com.utilisateurs.authservice.dto.LoginResponse;
import com.utilisateurs.authservice.dto.UnifiedLoginRequest;
import com.utilisateurs.authservice.feign.DisiClient;
import com.utilisateurs.authservice.model.Authentification;
import com.utilisateurs.authservice.repository.AuthentificationRepository;
import com.utilisateurs.authservice.util.JwtUtils;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class AuthentificationService {

    @Autowired
    private AuthentificationRepository authRepo;

    @Autowired
    private DisiClient disiClient;

    @Autowired
    private JwtUtils jwtUtils;

   @Transactional
    public LoginResponse login(UnifiedLoginRequest request) {
        String identifiant = request.getIdentifiant();
        String motDePasse = request.getMotDePasse();

        if (isEtudiant(identifiant)) {
            // Utiliser email = identifiant, numcarte = motDePasse
            EtudiantLoginRequest etuRequest = new EtudiantLoginRequest();
            etuRequest.setEmail(identifiant);
            etuRequest.setNumcarte(motDePasse);
            return loginEtudiant(etuRequest);
        } else {
            // Utiliser immatricul = identifiant, password = motDePasse
            LoginRequest empRequest = new LoginRequest();
            empRequest.setImmatricul(identifiant);
            empRequest.setPassword(motDePasse);
            return loginEmploye(empRequest);
        }
    }

    private boolean isEtudiant(String identifiant) {
        return identifiant.contains("@") || Character.isDigit(identifiant.charAt(0));
    }
    
    private LoginResponse loginEmploye(LoginRequest request) {
        Authentification auth = authRepo.findByUtilisateurImmatricul(request.getImmatricul())
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));

        if (!request.getPassword().equals(auth.getPassword())) {
            throw new RuntimeException("Mot de passe incorrect");
        }

        String role = auth.getUtilisateur().getRole().getNom();
        String token = jwtUtils.generateToken(request.getImmatricul(), role);
        String expiresAt = auth.getDateExpiration().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);

        return new LoginResponse(token, role, request.getImmatricul(), expiresAt);
    }

    private LoginResponse loginEtudiant(EtudiantLoginRequest request) {
        boolean isValidEtudiant = disiClient.validateEtudiant(request.getEmail(), request.getNumcarte());

        if (!isValidEtudiant) {
            throw new RuntimeException("Échec d'authentification : informations étudiantes incorrectes");
        }

        String token = jwtUtils.generateToken(request.getNumcarte(), "ETUDIANT");

        return new LoginResponse(
                token,
                "ETUDIANT",
                request.getNumcarte(),
                LocalDateTime.now().plusHours(2).format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
        );
    }

}
