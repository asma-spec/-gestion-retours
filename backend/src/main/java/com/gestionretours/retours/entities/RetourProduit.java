/**
 * Entité représentant un retour produit d'un client.
 * Liée à la table retour_produit dans MySQL.
 */
package com.gestionretours.retours.entities;

import java.time.LocalDate;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RetourProduit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le produit est obligatoire")
    private String produit;

    @NotBlank(message = "Le client est obligatoire")
    private String client;

    @NotBlank(message = "La raison est obligatoire")
    private String raison;

    @NotBlank(message = "L'état de traitement est obligatoire")
    private String etatTraitement;

    @NotNull(message = "La date est obligatoire")
    private LocalDate date;

    private int quantiteStock = 0;
}