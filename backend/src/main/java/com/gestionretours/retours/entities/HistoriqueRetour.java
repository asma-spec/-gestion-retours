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
public class HistoriqueRetour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "L'action est obligatoire")
    private String action;

    @NotBlank(message = "L'employé est obligatoire")
    private String employe;

    @NotNull(message = "La date est obligatoire")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "retour_id")
    @NotNull(message = "Le retour est obligatoire")
    private RetourProduit retour;
}