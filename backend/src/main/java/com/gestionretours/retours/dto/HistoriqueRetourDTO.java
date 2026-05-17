/**
 * DTO pour HistoriqueRetour.
 * Contient retourId au lieu de l'objet RetourProduit complet
 * pour éviter les références circulaires.
 */
package com.gestionretours.retours.dto;

import java.time.LocalDate;
import lombok.Data;

@Data
public class HistoriqueRetourDTO {

    private Long id;
    private String action;
    private String employe;
    private LocalDate date;
    private Long retourId;
}