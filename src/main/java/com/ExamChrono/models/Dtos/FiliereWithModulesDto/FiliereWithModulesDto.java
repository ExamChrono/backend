package com.ExamChrono.models.Dtos.FiliereWithModulesDto;

import com.ExamChrono.models.Dtos.ModulesDto.Modules2Dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class FiliereWithModulesDto {
    private Long id;
    private String nom;
    private String specialite;
    private String niveau;
    private String nombreEtudient;
    private List<Modules2Dto> modules;
}
