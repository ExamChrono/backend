package com.ExamChrono.services.interfaces;

import com.ExamChrono.models.Dtos.DelegueDto.DelegueDto;
import com.ExamChrono.models.Dtos.EtudiantDto.EtudiantDto;
import com.ExamChrono.models.Entities.Delegue;
import com.ExamChrono.models.Entities.Etudiant;

import java.util.List;

public interface DelegueService {
    List<DelegueDto> getAllDelegues();
    EtudiantDto loginDelegue(Etudiant etudiant);
    boolean createDelegue(Delegue delegue);
    boolean deleteDelegue(Long id);

    EtudiantDto getDelegueByEmail(Delegue delegue);
}
