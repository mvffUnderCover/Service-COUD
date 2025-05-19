package com.techservice.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "demande_depannage")
public class DemandeDepannage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_demande")
    private Integer idDemande;

    @Column(name = "id_etudiant", nullable = false)
    private String idEtudiant;

    @Column(name = "pavillon", nullable = false)
    private String nomPavillon;

    @Column(name = "num_chambre", nullable = false)
    private Integer numChambre;

    @Column(name = "date_soumission")
    private LocalDate dateSoumission;

    private String description;

    @Column(name = "statu", nullable = false)
    private String statu = "En attente"; // Valeur par défaut

    
    @JsonIgnore
    @OneToOne(mappedBy = "demande", cascade = CascadeType.ALL)
    private BonDeTravail bonDeTravail;

    // Constructeurs

    public DemandeDepannage() {
    }

    public DemandeDepannage(Integer idDemande, String idEtudiant, String nomPavillon, int numChambre,
                             LocalDate dateSoumission, String description, String statu, BonDeTravail bonDeTravail) {
        this.idDemande = idDemande;
        this.idEtudiant = idEtudiant;
        this.nomPavillon = nomPavillon;
        this.numChambre = numChambre;
        this.dateSoumission = dateSoumission;
        this.description = description;
        this.statu = statu;
        this.bonDeTravail = bonDeTravail;
    }

    // Getters / Setters

    public Integer getIdDemande() {
        return idDemande;
    }

    public void setIdDemande(Integer idDemande) {
        this.idDemande = idDemande;
    }

    public String getIdEtudiant() {
        return idEtudiant;
    }

    public void setIdEtudiant(String idEtudiant) {
        this.idEtudiant = idEtudiant;
    }

    public String getNomPavillon() {
        return nomPavillon;
    }

    public void setNomPavillon(String nomPavillon) {
        this.nomPavillon = nomPavillon;
    }

    public Integer getNumChambre() {
        return numChambre;
    }

    public void setNumChambre(Integer numChambre) {
        this.numChambre = numChambre;
    }

    public LocalDate getDateSoumission() {
        return dateSoumission;
    }

    public void setDateSoumission(LocalDate dateSoumission) {
        this.dateSoumission = dateSoumission;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatu() {
        return statu;
    }

    public void setStatu(String statu) {
        this.statu = statu;
    }

    public BonDeTravail getBonDeTravail() {
        return bonDeTravail;
    }

    public void setBonDeTravail(BonDeTravail bonDeTravail) {
        this.bonDeTravail = bonDeTravail;
    }
}
