/**
 * Controller REST pour la gestion des non-conformités.
 * Endpoints CRUD : /api/nonconformites
 */
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

import com.gestionretours.retours.dto.NonConformiteDTO;
import com.gestionretours.retours.service.NonConformiteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/nonconformites")
@CrossOrigin(origins = "*")
public class NonConformiteController {

    @Autowired
    private NonConformiteService ncService;

    @GetMapping
    public List<NonConformiteDTO> getAll() {
        return ncService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<NonConformiteDTO> getById(@PathVariable Long id) {
        return ncService.getById(id);
    }

    @PostMapping
    public NonConformiteDTO save(@Valid @RequestBody NonConformiteDTO dto) {
        return ncService.save(dto);
    }

    @PutMapping("/{id}")
    public NonConformiteDTO update(@PathVariable Long id,
            @Valid @RequestBody NonConformiteDTO dto) {
        return ncService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        ncService.delete(id);
    }
}