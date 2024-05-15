package com.ExamChrono.models.Dtos.DelegueDto;

import com.ExamChrono.models.Dtos.EtudiantDto.EtudiantDto;
import com.ExamChrono.models.Enums.RoleUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DelegueDto{
    private Long id;

    private EtudiantDto etudiant;
    private RoleUser roleUser;
}
