/**
 * Repository pour Utilisateur.
 * Hérite de JpaRepository pour les opérations CRUD automatiques.
 */
package com.gestionretours.retours.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gestionretours.retours.entities.Utilisateur;

public interface UtilisateurRepository 
    extends JpaRepository<Utilisateur, Long> {
}