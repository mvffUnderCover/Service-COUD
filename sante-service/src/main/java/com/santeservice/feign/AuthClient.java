package com.santeservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.santeservice.dto.UtilisateurDTO;
 
@FeignClient(name = "auth-service") // ou utilise le nom du service si tu fais du service discovery, url = "http://localhost:8081"
public interface AuthClient {

	@GetMapping("/auth/utilisateurs/{id}")
    UtilisateurDTO getUtilisateurById(@PathVariable String id);
}

