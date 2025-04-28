package com.utilisateurs.authservice.controller;

import com.utilisateurs.authservice.model.Role;
import com.utilisateurs.authservice.repository.RoleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth/roles")
@CrossOrigin(origins = "*") // à adapter selon ton front
public class RoleController {

    @Autowired
    private RoleRepository roleRepository;

    // 1. Liste des rôles
    @GetMapping
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    // 2. Obtenir un rôle par ID
    @GetMapping("/{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable int id) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Rôle non trouvé avec l'id : " + id));
        return ResponseEntity.ok(role);
    }

    // 3. Ajouter un rôle
    @PostMapping
    public Role createRole(@RequestBody Role role) {
        return roleRepository.save(role);
    }

    // 4. Modifier un rôle
    @PutMapping("/{id}")
    public Role updateRole(@PathVariable int id, @RequestBody Role updatedRole) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Rôle non trouvé avec l'id : " + id));

        role.setNom(updatedRole.getNom());
        return roleRepository.save(role);
    }

    // 5. Supprimer un rôle
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRole(@PathVariable int id) {
        if (!roleRepository.existsById(id)) {
            throw new EntityNotFoundException("Rôle non trouvé avec l'id : " + id);
        }
        roleRepository.deleteById(id);
        return ResponseEntity.ok("Rôle supprimé avec succès");
    }
}

