package com.techservice.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import com.techservice.dto.*;

@FeignClient(name = "auth-service")
public interface UtilisateurClient {

	@GetMapping("/auth/utilisateurs/{id}")
    UtilisateurDTO getUtilisateurById(@PathVariable String id);
}