package com.techservice.dto;

public class UtilisateurDTO {

    private String immatricul;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private String departement;
    private String role;
   
    
    // Getters et Setters
    

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


	


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}

}
