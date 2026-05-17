/**
 * Repository pour HistoriqueRetour.
 * Hérite de JpaRepository pour les opérations CRUD automatiques.
 * findByRetourId() : requête personnalisée générée automatiquement par Spring JPA.
 */
package com.gestionretours.retours.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.gestionretours.retours.entities.HistoriqueRetour;

public interface HistoriqueRetourRepository 
    extends JpaRepository<HistoriqueRetour, Long> {

   
    List<HistoriqueRetour> findByRetourId(Long retourId);
}