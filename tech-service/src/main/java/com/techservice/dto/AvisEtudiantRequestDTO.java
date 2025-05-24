package com.techservice.dto;

public class AvisEtudiantRequestDTO {
    private String idEtudiant;
    private String commentaire;
    private Integer idBonDeTravail; // pour lier à un bon
	public String getIdEtudiant() {
		return idEtudiant;
	}
	public void setIdEtudiant(String idEtudiant) {
		this.idEtudiant = idEtudiant;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	public Integer getIdBonDeTravail() {
		return idBonDeTravail;
	}
	public void setIdBonDeTravail(Integer idBonDeTravail) {
		this.idBonDeTravail = idBonDeTravail;
	}

    // getters/setters
    
    
}
