package com.gestionretours.retours.dto;

import java.time.LocalDate;
import lombok.Data;

@Data
public class RetourProduitDTO {

    private Long id;
    private String produit;
    private String client;
    private String raison;
    private String etatTraitement;
    private LocalDate date;
    private int quantiteStock;
}