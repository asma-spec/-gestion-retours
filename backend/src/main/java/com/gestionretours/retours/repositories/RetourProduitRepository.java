/**
 * Repository pour RetourProduit.
 * Hérite de JpaRepository pour les opérations CRUD automatiques.
 */
package com.gestionretours.retours.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gestionretours.retours.entities.RetourProduit;

public interface RetourProduitRepository 
    extends JpaRepository<RetourProduit, Long> {
}