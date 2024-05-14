package com.ExamChrono.models.Dtos.FiliereWithGroupesDto;

import com.ExamChrono.models.Dtos.GroupeDto.Groupe2Dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class FiliereWithGroupesDto {
    private Long id;
    private String nom;
    private String specialite;
    private String niveau;
    private String nombreEtudient;
    private List<Groupe2Dto> groupes;
}
