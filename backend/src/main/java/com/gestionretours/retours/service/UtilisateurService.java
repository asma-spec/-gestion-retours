/**
 * Service pour la gestion des utilisateurs.
 * Contient les opérations CRUD pour les utilisateurs.
 * Rôles : ADMIN, USER, QUALITE.
 */
package com.gestionretours.retours.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionretours.retours.dto.UtilisateurDTO;
import com.gestionretours.retours.entities.Utilisateur;
import com.gestionretours.retours.mapper.UtilisateurMapper;
import com.gestionretours.retours.repositories.UtilisateurRepository;

@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepo;

    @Autowired
    private UtilisateurMapper utilisateurMapper;

    public List<UtilisateurDTO> getAll() {
        return utilisateurMapper.toListDto(utilisateurRepo.findAll());
    }

    public Optional<UtilisateurDTO> getById(Long id) {
        Utilisateur u = utilisateurRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé : " + id));
        return Optional.of(utilisateurMapper.toDto(u));
    }

    public UtilisateurDTO save(UtilisateurDTO dto) {
        Utilisateur u = utilisateurMapper.fromDto(dto);
        return utilisateurMapper.toDto(utilisateurRepo.save(u));
    }

    public UtilisateurDTO update(Long id, UtilisateurDTO dto) {
        Utilisateur u = utilisateurRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé : " + id));
        u.setNom(dto.getNom());
        u.setEmail(dto.getEmail());
        u.setRole(dto.getRole());
        return utilisateurMapper.toDto(utilisateurRepo.save(u));
    }

    public void delete(Long id) {
        utilisateurRepo.deleteById(id);
    }
}