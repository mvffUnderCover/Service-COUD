package com.techservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "avis_etudiant")
public class AvisEtudiant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "id_etudiant")
    private String idEtudiant; // <-- Modifié en String

    private String commentaire;

    private Integer note; // Note optionnelle pour enrichir l'avis

    @ManyToOne
    @JoinColumn(name = "id_bon_de_travail")
    //@JsonIgnoreProperties("avisEtudiants")
    private BonDeTravail bonDeTravail;

    public AvisEtudiant() {}

    public AvisEtudiant(Integer id, String idEtudiant, String commentaire, Integer note, BonDeTravail bonDeTravail) {
        this.id = id;
        this.idEtudiant = idEtudiant;
        this.commentaire = commentaire;
        this.note = note;
        this.bonDeTravail = bonDeTravail;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getIdEtudiant() { return idEtudiant; }
    public void setIdEtudiant(String idEtudiant) { this.idEtudiant = idEtudiant; }

    public String getCommentaire() { return commentaire; }
    public void setCommentaire(String commentaire) { this.commentaire = commentaire; }

    public Integer getNote() { return note; }
    public void setNote(Integer note) { this.note = note; }

    public BonDeTravail getBonDeTravail() { return bonDeTravail; }
    public void setBonDeTravail(BonDeTravail bonDeTravail) { this.bonDeTravail = bonDeTravail; }
}
