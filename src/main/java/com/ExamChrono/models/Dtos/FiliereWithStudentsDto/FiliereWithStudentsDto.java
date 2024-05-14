package com.ExamChrono.models.Dtos.FiliereWithStudentsDto;

import com.ExamChrono.models.Dtos.EtudiantDto.EtudiantDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class FiliereWithStudentsDto {
    private Long id;
    private String nom;
    private String specialite;
    private String niveau;
    private String nombreEtudient;
    private List<EtudiantDto> etudiants;
}
