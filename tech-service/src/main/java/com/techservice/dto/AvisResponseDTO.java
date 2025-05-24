package com.techservice.dto;

public class AvisResponseDTO {
    private String idEtudiant;
    private String nomEtudiant;
    private String prenomEtudiant;
    private Integer idBonDeTravail;
    private String commentaire;

    // Getters & Setters
    public String getIdEtudiant() {
        return idEtudiant;
    }

    public void setIdEtudiant(String idEtudiant) {
        this.idEtudiant = idEtudiant;
    }

    public String getNomEtudiant() {
        return nomEtudiant;
    }

    public void setNomEtudiant(String nomEtudiant) {
        this.nomEtudiant = nomEtudiant;
    }

    public String getPrenomEtudiant() {
        return prenomEtudiant;
    }

    public void setPrenomEtudiant(String prenomEtudiant) {
        this.prenomEtudiant = prenomEtudiant;
    }

    public Integer getIdBonDeTravail() {
        return idBonDeTravail;
    }

    public void setIdBonDeTravail(Integer idBonDeTravail) {
        this.idBonDeTravail = idBonDeTravail;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }
}
