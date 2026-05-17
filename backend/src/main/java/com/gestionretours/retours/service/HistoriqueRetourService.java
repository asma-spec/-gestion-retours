/**
 * Service pour la gestion de l'historique des retours.
 * Permet de tracer toutes les actions effectuées sur les retours.
 * Recherche par retourId pour voir l'historique d'un retour spécifique.
 */
package com.gestionretours.retours.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionretours.retours.dto.HistoriqueRetourDTO;
import com.gestionretours.retours.entities.HistoriqueRetour;
import com.gestionretours.retours.entities.RetourProduit;
import com.gestionretours.retours.mapper.HistoriqueRetourMapper;
import com.gestionretours.retours.repositories.HistoriqueRetourRepository;
import com.gestionretours.retours.repositories.RetourProduitRepository;

@Service
public class HistoriqueRetourService {

    @Autowired
    private HistoriqueRetourRepository historiqueRepo;

    @Autowired
    private RetourProduitRepository retourRepo;

    @Autowired
    private HistoriqueRetourMapper historiqueMapper;

    public List<HistoriqueRetourDTO> getAll() {
        return historiqueMapper.toListDto(historiqueRepo.findAll());
    }

    public Optional<HistoriqueRetourDTO> getById(Long id) {
        HistoriqueRetour h = historiqueRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Historique non trouvé : " + id));
        return Optional.of(historiqueMapper.toDto(h));
    }

    public List<HistoriqueRetourDTO> getByRetourId(Long retourId) {
        return historiqueMapper.toListDto(historiqueRepo.findByRetourId(retourId));
    }

    public HistoriqueRetourDTO save(HistoriqueRetourDTO dto) {
        HistoriqueRetour h = historiqueMapper.fromDto(dto);
        
        RetourProduit retour = retourRepo.findById(dto.getRetourId())
                .orElseThrow(() -> new RuntimeException("Retour non trouvé : " + dto.getRetourId()));
        h.setRetour(retour);
        return historiqueMapper.toDto(historiqueRepo.save(h));
    }

    public void delete(Long id) {
        historiqueRepo.deleteById(id);
    }
}