package com.ExamChrono.models.Dtos.GroupeDto;

import com.ExamChrono.models.Dtos.FiliereDto.FiliereDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Groupe3Dto {
    private Long id;
    private Long nbrEtudiant;
    private FiliereDto filiere;
}
