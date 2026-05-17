package com.gestionretours.retours.dto;

import java.time.LocalDate;
import lombok.Data;

@Data
public class NonConformiteDTO {

    private Long id;
    private String description;
    private String gravite;
    private LocalDate date;
    private String produit;
}