package com.gestionretours.retours.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.gestionretours.retours.entities.HistoriqueRetour;

public interface HistoriqueRetourRepository 
    extends JpaRepository<HistoriqueRetour, Long> {

   
    List<HistoriqueRetour> findByRetourId(Long retourId);
}