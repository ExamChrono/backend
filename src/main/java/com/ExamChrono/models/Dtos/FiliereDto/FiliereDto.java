package com.ExamChrono.models.Dtos.FiliereDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FiliereDto {
    private Long id;
    private String nom;
    private String specialite;
    private String niveau;
    private String nombreEtudient;
}
