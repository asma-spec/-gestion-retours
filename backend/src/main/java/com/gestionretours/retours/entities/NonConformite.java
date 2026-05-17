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
public class NonConformite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "La description est obligatoire")
    @Size(min = 5, message = "La description doit contenir au moins 5 caractères")
    private String description;

    @NotBlank(message = "La gravité est obligatoire")
    private String gravite;

    @NotNull(message = "La date est obligatoire")
    private LocalDate date;

    @NotBlank(message = "Le produit est obligatoire")
    private String produit;
}