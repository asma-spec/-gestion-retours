/**
 * DTO pour Utilisateur.
 * Utilisé pour transférer les données utilisateur.
 */
package com.gestionretours.retours.dto;

import lombok.Data;

@Data
public class UtilisateurDTO {

    private Long id;
    private String nom;
    private String email;
    private String role;
}