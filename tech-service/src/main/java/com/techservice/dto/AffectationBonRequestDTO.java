package com.techservice.dto;


public class AffectationBonRequestDTO {
    private Integer idBon;
    private String idOuvrier;
    private String materielConsomme;
	public Integer getIdBon() {
		return idBon;
	}
	public void setIdBon(Integer idBon) {
		this.idBon = idBon;
	}
	public String getIdOuvrier() {
		return idOuvrier;
	}
	public void setIdOuvrier(String idOuvrier) {
		this.idOuvrier = idOuvrier;
	}
	public String getMaterielConsomme() {
		return materielConsomme;
	}
	public void setMaterielConsomme(String materielConsomme) {
		this.materielConsomme = materielConsomme;
	}
    
}