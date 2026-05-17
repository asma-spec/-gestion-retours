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