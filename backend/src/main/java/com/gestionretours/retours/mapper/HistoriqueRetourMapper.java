package com.gestionretours.retours.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gestionretours.retours.dto.HistoriqueRetourDTO;
import com.gestionretours.retours.entities.HistoriqueRetour;

@Component
public class HistoriqueRetourMapper {

    @Autowired
    private ModelMapper mmMapper;

    public HistoriqueRetourDTO toDto(HistoriqueRetour h) {
        HistoriqueRetourDTO dto = new HistoriqueRetourDTO();
        dto.setId(h.getId());
        dto.setAction(h.getAction());
        dto.setEmploye(h.getEmploye());
        dto.setDate(h.getDate());
        if (h.getRetour() != null) {
            dto.setRetourId(h.getRetour().getId());
        }
        return dto;
    }

    public HistoriqueRetour fromDto(HistoriqueRetourDTO dto) {
        return mmMapper.map(dto, HistoriqueRetour.class);
    }

    public List<HistoriqueRetourDTO> toListDto(List<HistoriqueRetour> liste) {
        return liste.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}