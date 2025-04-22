package com.utilisateurs.authservice.dto;


public class UpdatePasswordRequest {
	
	
    private String ancienPassword;
    private String nouveauPassword;
    
    
	public String getAncienPassword() {
		return ancienPassword;
	}
	public void setAncienPassword(String ancienPassword) {
		this.ancienPassword = ancienPassword;
	}
	public String getNouveauPassword() {
		return nouveauPassword;
	}
	public void setNouveauPassword(String nouveauPassword) {
		this.nouveauPassword = nouveauPassword;
	}

}
