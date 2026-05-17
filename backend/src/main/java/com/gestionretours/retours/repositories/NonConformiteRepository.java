package com.gestionretours.retours.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gestionretours.retours.entities.NonConformite;

public interface NonConformiteRepository 
    extends JpaRepository<NonConformite, Long> {
}