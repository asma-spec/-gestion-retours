package com.gestionretours.retours.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionretours.retours.dto.NonConformiteDTO;
import com.gestionretours.retours.entities.NonConformite;
import com.gestionretours.retours.mapper.NonConformiteMapper;
import com.gestionretours.retours.repositories.NonConformiteRepository;

@Service
public class NonConformiteService {

    @Autowired
    private NonConformiteRepository ncRepo;

    @Autowired
    private NonConformiteMapper ncMapper;

    public List<NonConformiteDTO> getAll() {
        return ncMapper.toListDto(ncRepo.findAll());
    }

    public Optional<NonConformiteDTO> getById(Long id) {
        NonConformite nc = ncRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("NonConformite non trouvée : " + id));
        return Optional.of(ncMapper.toDto(nc));
    }

    public NonConformiteDTO save(NonConformiteDTO dto) {
        NonConformite nc = ncMapper.fromDto(dto);
        return ncMapper.toDto(ncRepo.save(nc));
    }

    public NonConformiteDTO update(Long id, NonConformiteDTO dto) {
        NonConformite nc = ncRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("NonConformite non trouvée : " + id));
        nc.setDescription(dto.getDescription());
        nc.setGravite(dto.getGravite());
        nc.setDate(dto.getDate());
        nc.setProduit(dto.getProduit());
        return ncMapper.toDto(ncRepo.save(nc));
    }

    public void delete(Long id) {
        ncRepo.deleteById(id);
    }
}