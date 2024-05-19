package com.ExamChrono.services.interfaces;

import com.ExamChrono.models.Dtos.FiliereDto.FiliereDto;
import com.ExamChrono.models.Entities.Filiere;

import java.util.List;

public interface FiliereService {
    List<FiliereDto> getAllFilieres();
    boolean updateFiliere(Filiere filiere);
    boolean createFiliere(Filiere filiere);
    boolean deleteFiliere(Long id
    );

    FiliereDto getFiliereByIdDelegue(Long id);
}
