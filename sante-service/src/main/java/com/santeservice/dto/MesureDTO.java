package com.santeservice.dto;

import java.util.Date;

public class MesureDTO {

    private Integer idMesure;
    private Date dateMesure;
    private Float poids;
    private Float taille;
    private String tensionArterielle;
    private Integer pouls;
    private String numeroDossier;
	public Integer getIdMesure() {
		return idMesure;
	}
	public void setIdMesure(Integer idMesure) {
		this.idMesure = idMesure;
	}
	public Date getDateMesure() {
		return dateMesure;
	}
	public void setDateMesure(Date dateMesure) {
		this.dateMesure = dateMesure;
	}
	public Float getPoids() {
		return poids;
	}
	public void setPoids(Float poids) {
		this.poids = poids;
	}
	public Float getTaille() {
		return taille;
	}
	public void setTaille(Float taille) {
		this.taille = taille;
	}
	public String getTensionArterielle() {
		return tensionArterielle;
	}
	public void setTensionArterielle(String tensionArterielle) {
		this.tensionArterielle = tensionArterielle;
	}
	public Integer getPouls() {
		return pouls;
	}
	public void setPouls(Integer pouls) {
		this.pouls = pouls;
	}
	public String getNumeroDossier() {
		return numeroDossier;
	}
	public void setNumeroDossier(String numeroDossier) {
		this.numeroDossier = numeroDossier;
	}

    // Getters & Setters
    
}
