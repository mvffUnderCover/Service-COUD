package com.techservice.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.techservice.dto.*;

@FeignClient(name = "auth-service", url = "http://localhost:8081") // adapte si différent
public interface UtilisateurClient {

    @GetMapping("/api/utilisateurs/{id}")
    UtilisateurDTO getUtilisateurById(@PathVariable String id); 
}
