package com.ExamChrono.services.interfaces;

import com.ExamChrono.models.Dtos.EtudiantDto.EtudiantDto;
import com.ExamChrono.models.Entities.Etudiant;

import java.util.List;

public interface EtudiantService {
    List<EtudiantDto> getAllEtudiants();
    boolean loginEtudiant(Etudiant etudiant);
    boolean updateEtudiant(Etudiant etudiant);
    boolean createEtudiant(Etudiant etudiant, boolean validation);
    boolean deleteEtudiant(Etudiant etudiant);
}
