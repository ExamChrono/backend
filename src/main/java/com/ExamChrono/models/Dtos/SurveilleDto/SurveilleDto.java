package com.ExamChrono.models.Dtos.SurveilleDto;

import com.ExamChrono.models.Dtos.GroupeDto.Groupe3Dto;
import com.ExamChrono.models.Entities.Enseignant;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SurveilleDto {
    private Long id;

    private String nom;
    private String Code;

    private Groupe3Dto groupe;
    private Enseignant enseignant;
}
