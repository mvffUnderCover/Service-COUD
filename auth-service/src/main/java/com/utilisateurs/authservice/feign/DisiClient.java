package com.utilisateurs.authservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "disi-mock-api", url = "http://localhost:8082")
public interface DisiClient {

    @PostMapping("/api/etudiants/validate")
    boolean validateEtudiant(@RequestParam String email, @RequestParam String numcarte);
}
