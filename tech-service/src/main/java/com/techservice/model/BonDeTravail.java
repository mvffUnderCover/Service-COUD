package com.techservice.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "bon_travail")
public class BonDeTravail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bon_travail")
    private Integer idBonDeTravail;
    
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "id_demande")
    private DemandeDepannage demande;

    @Column(name = "id_chefresidence")
    private String idChefDeResidence;

    @Column(name = "description")
    private String descriptionTravail;

    @Column(name = "lieu")
    private String lieuIntervention;
    
    @Column(name = "id_ouvrier")
    private String idOuvrier;

    @Column(name = "etat")
    private String etat; // Exemple : "Nouveau", "Section affectée", "Exécuté", "Clôturé"

    @Column(name = "materiel_consomme")
    private String materielConsomme;

    @Column(name = "date_creation")
    private LocalDate dateCreation;

    @Column(name = "date_intervention")
    private LocalDate dateIntervention;

    @Column(name = "date_cloture")
    private LocalDate dateCloture;

    @Column(name = "cree_par")
    private String creePar;
    
    @ManyToOne
    @JoinColumn(name = "id_section")
    private Section section;

    @JsonIgnore
    @OneToMany(mappedBy = "bonDeTravail", cascade = CascadeType.ALL)
    private List<AvisEtudiant> avisEtudiants;

    // === CONSTRUCTEURS ===

    public BonDeTravail() {
    }

    public BonDeTravail(Integer idBonDeTravail, DemandeDepannage demande, String idChefDeResidence,
                        String descriptionTravail, String lieuIntervention, String idChefDeSection,
                        String idOuvrier, String etat, String materielConsomme,
                        LocalDate dateCreation, LocalDate dateIntervention, LocalDate dateCloture,
                        String creePar, Section section, List<AvisEtudiant> avisEtudiants) {
        this.idBonDeTravail = idBonDeTravail;
        this.demande = demande;
        this.idChefDeResidence = idChefDeResidence;
        this.descriptionTravail = descriptionTravail;
        this.lieuIntervention = lieuIntervention;
        this.idOuvrier = idOuvrier;
        this.etat = etat;
        this.materielConsomme = materielConsomme;
        this.dateCreation = dateCreation;
        this.dateIntervention = dateIntervention;
        this.dateCloture = dateCloture;
        this.creePar = creePar;
        this.section = section;
        this.avisEtudiants = avisEtudiants;
    }

    // === GETTERS ET SETTERS ===

    public Integer getIdBonDeTravail() {
        return idBonDeTravail;
    }

    public void setIdBonDeTravail(Integer idBonDeTravail) {
        this.idBonDeTravail = idBonDeTravail;
    }

    public DemandeDepannage getDemande() {
        return demande;
    }

    public void setDemande(DemandeDepannage demande) {
        this.demande = demande;
    }

    public String getIdChefDeResidence() {
        return idChefDeResidence;
    }

    public void setIdChefDeResidence(String idChefDeResidence) {
        this.idChefDeResidence = idChefDeResidence;
    }

    public String getDescriptionTravail() {
        return descriptionTravail;
    }

    public void setDescriptionTravail(String descriptionTravail) {
        this.descriptionTravail = descriptionTravail;
    }

    public String getLieuIntervention() {
        return lieuIntervention;
    }

    public void setLieuIntervention(String lieuIntervention) {
        this.lieuIntervention = lieuIntervention;
    }

   
    public String getIdOuvrier() {
        return idOuvrier;
    }

    public void setIdOuvrier(String idOuvrier) {
        this.idOuvrier = idOuvrier;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getMaterielConsomme() {
        return materielConsomme;
    }

    public void setMaterielConsomme(String materielConsomme) {
        this.materielConsomme = materielConsomme;
    }

    public LocalDate getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDate dateCreation) {
        this.dateCreation = dateCreation;
    }

    public LocalDate getDateIntervention() {
        return dateIntervention;
    }

    public void setDateIntervention(LocalDate dateIntervention) {
        this.dateIntervention = dateIntervention;
    }


    public LocalDate getDateCloture() {
        return dateCloture;
    }

    public void setDateCloture(LocalDate dateCloture) {
        this.dateCloture = dateCloture;
    }

    public String getCreePar() {
        return creePar;
    }

    public void setCreePar(String creePar) {
        this.creePar = creePar;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public List<AvisEtudiant> getAvisEtudiants() {
        return avisEtudiants;
    }

    public void setAvisEtudiants(List<AvisEtudiant> avisEtudiants) {
        this.avisEtudiants = avisEtudiants;
    }
}
