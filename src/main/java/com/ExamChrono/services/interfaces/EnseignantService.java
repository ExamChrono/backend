package com.ExamChrono.services.interfaces;

import com.ExamChrono.models.Entities.Enseignant;

import java.util.List;

public interface EnseignantService {
    List<Enseignant> getAllEnseignants();
    boolean loginEnseignant(Enseignant enseignant);
    boolean updateEnseignant(Enseignant enseignant);
    boolean createEnseignant(Enseignant enseignant, boolean validation);
    boolean deleteEnseignant(Enseignant enseignant);
}
