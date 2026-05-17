package com.gestionretours.retours.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gestionretours.retours.dto.RetourProduitDTO;
import com.gestionretours.retours.entities.RetourProduit;

@Component
public class RetourProduitMapper {

    @Autowired
    private ModelMapper mmMapper;

    
    public RetourProduitDTO toDto(RetourProduit retour) {
        return mmMapper.map(retour, RetourProduitDTO.class);
    }

    
    public RetourProduit fromDto(RetourProduitDTO dto) {
        return mmMapper.map(dto, RetourProduit.class);
    }

   
    public java.util.List<RetourProduitDTO> toListDto(
            java.util.List<RetourProduit> liste) {
        return liste.stream()
                .map(r -> mmMapper.map(r, RetourProduitDTO.class))
                .collect(java.util.stream.Collectors.toList());
    }
}