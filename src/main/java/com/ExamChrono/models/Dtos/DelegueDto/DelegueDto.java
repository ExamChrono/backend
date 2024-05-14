package com.ExamChrono.models.Dtos.DelegueDto;

import com.ExamChrono.models.Dtos.EtudiantDto.EtudiantDto;
import com.ExamChrono.models.Entities.Etudiant;
import com.ExamChrono.models.Entities.Filiere;

import java.util.List;

public class DelegueDto{
    private Long id;

    private List<Etudiant> etudiants;
}
