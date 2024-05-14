package com.ExamChrono.services.interfaces;

import com.ExamChrono.models.Entities.Delegue;
import com.ExamChrono.models.Entities.Etudiant;

import java.util.List;

public interface DelegueService {
    List<Delegue> getAllDelegues();
    boolean loginDelegue(Etudiant etudiant);
    boolean createDelegue(Delegue delegue);
    boolean deleteDelegue(Delegue delegue);
}
