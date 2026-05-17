/**
 * Mapper pour convertir Utilisateur ↔ UtilisateurDTO.
 * Utilise ModelMapper pour la conversion automatique.
 */
package com.gestionretours.retours.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gestionretours.retours.dto.UtilisateurDTO;
import com.gestionretours.retours.entities.Utilisateur;

@Component
public class UtilisateurMapper {

    @Autowired
    private ModelMapper mmMapper;

    public UtilisateurDTO toDto(Utilisateur u) {
        return mmMapper.map(u, UtilisateurDTO.class);
    }

    public Utilisateur fromDto(UtilisateurDTO dto) {
        return mmMapper.map(dto, Utilisateur.class);
    }

    public java.util.List<UtilisateurDTO> toListDto(
            java.util.List<Utilisateur> liste) {
        return liste.stream()
                .map(u -> mmMapper.map(u, UtilisateurDTO.class))
                .collect(java.util.stream.Collectors.toList());
    }
}