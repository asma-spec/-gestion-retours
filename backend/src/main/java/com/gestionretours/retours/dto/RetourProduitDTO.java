/**
 * DTO pour RetourProduit.
 * Utilisé pour transférer les données entre le backend et le frontend.
 * Ne contient pas les données sensibles comme quantiteStock.
 */
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