package com.utilisateurs.authservice.controller;



import com.utilisateurs.authservice.dto.LoginResponse;
import com.utilisateurs.authservice.dto.UnifiedLoginRequest;
import com.utilisateurs.authservice.service.AuthentificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthentificationController {

    @Autowired
    private AuthentificationService authService;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody UnifiedLoginRequest request) {
        return authService.login(request);
    }
}
