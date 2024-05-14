package com.ExamChrono.models.Dtos.FiliereDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FiliereDto {
    private Long id;
    private String nom;
    private String specialite;
    private String niveau;
    private String nombreEtudient;
}
