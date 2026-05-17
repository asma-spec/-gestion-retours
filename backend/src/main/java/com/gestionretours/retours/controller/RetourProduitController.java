/**
 * Controller REST pour la gestion des retours produits.
 * Endpoints :
 * GET    /api/retours         - Liste tous les retours
 * GET    /api/retours/{id}    - Récupère un retour par id
 * POST   /api/retours         - Crée un nouveau retour
 * PUT    /api/retours/{id}    - Modifie un retour
 * PUT    /api/retours/{id}/traiter - Traite un retour (service qualité)
 * DELETE /api/retours/{id}    - Supprime un retour
 */
package com.gestionretours.retours.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestionretours.retours.dto.RetourProduitDTO;
import com.gestionretours.retours.service.RetourProduitService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/retours")
@CrossOrigin(origins = "*")
public class RetourProduitController {

    @Autowired
    private RetourProduitService retourService;

    @GetMapping
    public List<RetourProduitDTO> getAll() {
        return retourService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<RetourProduitDTO> getById(@PathVariable Long id) {
        return retourService.getById(id);
    }

    @PostMapping
    public RetourProduitDTO save(@Valid @RequestBody RetourProduitDTO dto) {
        return retourService.save(dto);
    }

    @PutMapping("/{id}")
    public RetourProduitDTO update(@PathVariable Long id,
            @Valid @RequestBody RetourProduitDTO dto) {
        return retourService.update(id, dto);
    }

    @PutMapping("/{id}/traiter")
    public RetourProduitDTO traiter(@PathVariable Long id,
            @RequestBody Map<String, String> body) {
        return retourService.traiter(id, body.get("etat"), body.get("employe"));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        retourService.delete(id);
    }
}