/**
 * Service pour la gestion des retours produits.
 * Contient la logique métier :
 * - Création automatique d'un HistoriqueRetour lors du traitement
 * - Mise à jour du stock si état = "Retourné en stock"
 * - Suppression des historiques liés avant suppression du retour
 */
package com.gestionretours.retours.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionretours.retours.dto.RetourProduitDTO;
import com.gestionretours.retours.entities.HistoriqueRetour;
import com.gestionretours.retours.entities.RetourProduit;
import com.gestionretours.retours.mapper.RetourProduitMapper;
import com.gestionretours.retours.repositories.HistoriqueRetourRepository;
import com.gestionretours.retours.repositories.RetourProduitRepository;

@Service
public class RetourProduitService {

    @Autowired
    private RetourProduitRepository retourRepo;

    @Autowired
    private HistoriqueRetourRepository historiqueRepo;

    @Autowired
    private RetourProduitMapper retourMapper;

    
    public List<RetourProduitDTO> getAll() {
        return retourMapper.toListDto(retourRepo.findAll());
    }

    
    public Optional<RetourProduitDTO> getById(Long id) {
        RetourProduit retour = retourRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Retour non trouvé : " + id));
        return Optional.of(retourMapper.toDto(retour));
    }

    
    public RetourProduitDTO save(RetourProduitDTO dto) {
        RetourProduit retour = retourMapper.fromDto(dto);
        retour.setEtatTraitement("En cours");
        return retourMapper.toDto(retourRepo.save(retour));
    }

    
    public RetourProduitDTO update(Long id, RetourProduitDTO dto) {
        RetourProduit retour = retourRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Retour non trouvé : " + id));
        retour.setProduit(dto.getProduit());
        retour.setClient(dto.getClient());
        retour.setRaison(dto.getRaison());
        retour.setEtatTraitement(dto.getEtatTraitement());
        retour.setDate(dto.getDate());
        return retourMapper.toDto(retourRepo.save(retour));
    }

    
    public RetourProduitDTO traiter(Long id, String nouvelEtat, String employe) {
        RetourProduit retour = retourRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Retour non trouvé : " + id));

        
        if (retour.getEtatTraitement().equals("Rejeté")) {
            throw new RuntimeException("Ce retour est déjà rejeté, impossible de le retraiter !");
        }

        retour.setEtatTraitement(nouvelEtat);

       
        if (nouvelEtat.equals("Retourné en stock")) {
            retour.setQuantiteStock(retour.getQuantiteStock() + 1);
        }

        retourRepo.save(retour);

   
        HistoriqueRetour historique = new HistoriqueRetour();
        historique.setAction(nouvelEtat);
        historique.setEmploye(employe);
        historique.setDate(LocalDate.now());
        historique.setRetour(retour);
        historiqueRepo.save(historique);

        return retourMapper.toDto(retour);
    }

    
    public void delete(Long id) {
       
        List<HistoriqueRetour> historiques = historiqueRepo.findByRetourId(id);
        historiqueRepo.deleteAll(historiques);
        
        
        retourRepo.deleteById(id);
    }
}