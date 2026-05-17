package com.gestionretours.retours.controller;

import java.util.List;
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

import com.gestionretours.retours.dto.UtilisateurDTO;
import com.gestionretours.retours.service.UtilisateurService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/utilisateurs")
@CrossOrigin(origins = "*")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping
    public List<UtilisateurDTO> getAll() {
        return utilisateurService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<UtilisateurDTO> getById(@PathVariable Long id) {
        return utilisateurService.getById(id);
    }

    @PostMapping
    public UtilisateurDTO save(@Valid @RequestBody UtilisateurDTO dto) {
        return utilisateurService.save(dto);
    }

    @PutMapping("/{id}")
    public UtilisateurDTO update(@PathVariable Long id,
            @Valid @RequestBody UtilisateurDTO dto) {
        return utilisateurService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        utilisateurService.delete(id);
    }
}