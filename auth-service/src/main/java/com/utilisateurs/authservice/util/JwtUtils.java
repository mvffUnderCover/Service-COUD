package com.utilisateurs.authservice.util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JwtUtils {

    // Clé secrète pour signer le token (doit être suffisamment longue pour HS512)
    private static final String JWT_SECRET = "3b6e27bc43aee3cde2e61642f7b27aa8c1cf3e7c54dd8fefdf95e5478d8d7f4b5c3a61259e31a730e87bbd32de97d71c";
    
    // Durée de validité du token : ici, 24 heures
    private static final long JWT_EXPIRATION_MS = 86400000;

    // Clé cryptographique HMAC
    private final SecretKey secretKey = Keys.hmacShaKeyFor(JWT_SECRET.getBytes(StandardCharsets.UTF_8));

    /**
     * Génère un token JWT contenant l'immatriculation et le rôle
     */
    public String generateToken(String immatricul, String role) {
        return Jwts.builder()
                .setSubject(immatricul)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + JWT_EXPIRATION_MS))
                .signWith(secretKey, SignatureAlgorithm.HS512)
                .compact();
    }

    /**
     * Récupère les informations (claims) à partir du token JWT
     */
    public Claims getClaimsFromToken(String token) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (JwtException e) {
            // On peut logguer ici pour traçabilité si besoin
            return null;
        }
    }

    /**
     * Valide si le token est bien formé et non expiré
     */
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            // Token invalide ou mal formé
            return false;
        }
    }
}
