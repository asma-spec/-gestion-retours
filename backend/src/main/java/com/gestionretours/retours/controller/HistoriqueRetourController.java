package com.gestionretours.retours.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestionretours.retours.dto.HistoriqueRetourDTO;
import com.gestionretours.retours.service.HistoriqueRetourService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/historiques")
@CrossOrigin(origins = "*")
public class HistoriqueRetourController {

    @Autowired
    private HistoriqueRetourService historiqueService;

    @GetMapping
    public List<HistoriqueRetourDTO> getAll() {
        return historiqueService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<HistoriqueRetourDTO> getById(@PathVariable Long id) {
        return historiqueService.getById(id);
    }

    @GetMapping("/retour/{retourId}")
    public List<HistoriqueRetourDTO> getByRetourId(@PathVariable Long retourId) {
        return historiqueService.getByRetourId(retourId);
    }

    @PostMapping
    public HistoriqueRetourDTO save(@Valid @RequestBody HistoriqueRetourDTO dto) {
        return historiqueService.save(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        historiqueService.delete(id);
    }
}