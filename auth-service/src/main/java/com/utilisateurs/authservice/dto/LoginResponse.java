package com.utilisateurs.authservice.dto;


public class LoginResponse {
    private String token;
    private String role;
    private String immatricul;
    private String duree;

    public LoginResponse(String token, String role, String email, String duree) {
        this.token = token;
        this.role = role;
        this.immatricul = email;
        this.duree = duree;
    }

	public String getToken() {
		return token;
	}

	public String getRole() {
		return role;
	}
	
	public String getImmatricul() {
		return immatricul;
	}
	
	public String getExpiresAt() {
		return duree;
	}

}
