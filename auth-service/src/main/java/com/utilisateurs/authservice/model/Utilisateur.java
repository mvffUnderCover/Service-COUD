package com.utilisateurs.authservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
@Table(name = "utilisateurs")
public class Utilisateur {

    @Id
    private String immatricul;

    private String nom;

    private String prenom;

    @Column(unique = true, nullable = false)
    private String email;

    private String telephone;

    private String departement;
    
    private Integer idSection; // ID provenant de tech-service
    
    //@Column(name = "unite_organisationnelle")
    //private String uniteOrganisationnelle;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private Role role;
    
    @JsonIgnore
    @OneToOne(mappedBy = "utilisateur", cascade = CascadeType.ALL)
    private Authentification authentification;


    // === Getters & Setters ===

    public String getImmatricul() {
        return immatricul;
    }

    public void setImmatricul(String immatricul) {
        this.immatricul = immatricul;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    public Authentification getAuthentification() {
        return authentification;
    }

    public void setAuthentification(Authentification authentification) {
        this.authentification = authentification;
    }

	public Integer getIdSection() {
		return idSection;
	}

	public void setIdSection(int idSection) {
		this.idSection = idSection;
	}

	

}

