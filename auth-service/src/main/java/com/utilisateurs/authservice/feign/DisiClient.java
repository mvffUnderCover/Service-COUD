package com.utilisateurs.authservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import com.utilisateurs.authservice.dto.EtudiantDTO;


@FeignClient(name = "disi-mock-api") //url = "http://localhost:8082";
public interface DisiClient {

    @PostMapping("/disi/validate")
    boolean validateEtudiant(@RequestParam String email, @RequestParam String numcarte);
    @GetMapping("/disi/etudiants/{numcarte}")
    EtudiantDTO getByNumCarte(@PathVariable("numcarte") String numcarte);
}
