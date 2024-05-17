package com.ExamChrono.services.interfaces;

import com.ExamChrono.models.Dtos.FiliereEtudiantDto.FiliereEtudiantDto;
import com.ExamChrono.models.Dtos.FiliereWithStudentsDto.FiliereWithStudentsDto;

import java.util.List;

public interface FiliereEtudiantService {
    List<FiliereWithStudentsDto> getAllFiliereEtudiant();
    boolean addEtudiantToFiliere(FiliereEtudiantDto filiereEtudiantDto);
    boolean deleteEtudiantFromFiliere(Long filiereId,Long etudiantId);
}
