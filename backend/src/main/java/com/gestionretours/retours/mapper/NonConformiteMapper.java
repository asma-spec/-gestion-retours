/**
 * Mapper pour convertir NonConformite ↔ NonConformiteDTO.
 * Utilise ModelMapper pour la conversion automatique.
 */
package com.gestionretours.retours.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gestionretours.retours.dto.NonConformiteDTO;
import com.gestionretours.retours.entities.NonConformite;

@Component
public class NonConformiteMapper {

    @Autowired
    private ModelMapper mmMapper;

    public NonConformiteDTO toDto(NonConformite nc) {
        return mmMapper.map(nc, NonConformiteDTO.class);
    }

    public NonConformite fromDto(NonConformiteDTO dto) {
        return mmMapper.map(dto, NonConformite.class);
    }

    public java.util.List<NonConformiteDTO> toListDto(
            java.util.List<NonConformite> liste) {
        return liste.stream()
                .map(n -> mmMapper.map(n, NonConformiteDTO.class))
                .collect(java.util.stream.Collectors.toList());
    }
}