package com.santeservice.dto;



public class UtilisateurDTO {
	private String immatricul;
    private String nom;
    private String prenom;
    private String email;
    private String role;
    private String faculte;
    private String dateLieuNaissance;
    private String situationFamiliale;
    private Integer nombreEnfants;
    private String niveauEtude;
    // autres champs selon besoin
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getFaculte() {
		return faculte;
	}
	public void setFaculte(String faculte) {
		this.faculte = faculte;
	}
	public String getDateLieuNaissance() {
		return dateLieuNaissance;
	}
	public void setDateLieuNaissance(String dateLieuNaissance) {
		this.dateLieuNaissance = dateLieuNaissance;
	}
	public String getSituationFamiliale() {
		return situationFamiliale;
	}
	public void setSituationFamiliale(String situationFamiliale) {
		this.situationFamiliale = situationFamiliale;
	}
	public Integer getNombreEnfants() {
		return nombreEnfants;
	}
	public void setNombreEnfants(Integer nombreEnfants) {
		this.nombreEnfants = nombreEnfants;
	}
	public String getNiveauEtude() {
		return niveauEtude;
	}
	public void setNiveauEtude(String niveauEtude) {
		this.niveauEtude = niveauEtude;
	}
	
}
