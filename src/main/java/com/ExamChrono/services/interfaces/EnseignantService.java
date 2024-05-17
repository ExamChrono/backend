package com.ExamChrono.services.interfaces;

import com.ExamChrono.models.Dtos.EnseignantDto.EnseignantDto;
import com.ExamChrono.models.Entities.Enseignant;

import java.util.List;

public interface EnseignantService {
    List<Enseignant> getAllEnseignants();
    EnseignantDto loginEnseignant(Enseignant enseignant);
    boolean updateEnseignant(Enseignant enseignant);
    boolean createEnseignant(Enseignant enseignant, boolean validation);
    boolean deleteEnseignant(Long id);

    EnseignantDto getEnseignantByEmail(Enseignant enseignant);
}
