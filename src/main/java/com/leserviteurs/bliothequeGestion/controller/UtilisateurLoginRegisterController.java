package com.leserviteurs.bliothequeGestion.controller;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leserviteurs.bliothequeGestion.model.Utilisateur;
import com.leserviteurs.bliothequeGestion.repository.UtilisateursRepository;

@RestController
@RequestMapping("/api/auth")
public class UtilisateurLoginRegisterController {
    private final UtilisateursRepository utilisateursRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public UtilisateurLoginRegisterController(UtilisateursRepository utilisateursRepository,
            PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.utilisateursRepository = utilisateursRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Utilisateur utilisateur) {
        if (utilisateursRepository.findByNom(utilisateur.getNom()) != null) {
            return ResponseEntity.status(Response.SC_CONFLICT).body("Nom d'utilisateur déjà pris");
        }
        utilisateur.setMotDePasse(passwordEncoder.encode(utilisateur.getMotDePasse()));
        utilisateursRepository.save(utilisateur);
        return ResponseEntity.status(Response.SC_CREATED).body(utilisateur);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Utilisateur utilisateur) {
        // La gestion de l'authentification est prise en charge par Spring Security
        try {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(utilisateur.getNom(), utilisateur.getMotDePasse()));
        return ResponseEntity.ok("Authentification réussie");
        } catch (Exception e) {
            return ResponseEntity.status(Response.SC_UNAUTHORIZED).body("Nom d'utilisateur ou mot de passe incorrect");
        }
    }

}
