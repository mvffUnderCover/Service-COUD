package com.utilisateurs.authservice.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.persistence.*;

@Entity
public class Authentification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAuth;

    @Column(nullable = false)
    private String password;

    private String jeton;

    private LocalDateTime dateExpiration;
    
    @JsonIgnore
    @OneToOne 
    @JoinColumn(name = "immatricul", referencedColumnName = "immatricul")
    private Utilisateur utilisateur;

    // Getters et Setters

    public int getIdAuth() {
        return idAuth;
    }

    public void setIdAuth(int idAuth) {
        this.idAuth = idAuth;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJeton() {
        return jeton;
    }

    public void setJeton(String jeton) {
        this.jeton = jeton;
    }

    public LocalDateTime getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(LocalDateTime dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
}
