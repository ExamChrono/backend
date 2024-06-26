package com.ExamChrono.services.interfaces;

import com.ExamChrono.models.Dtos.SurveilleDto.SurveilleDto;
import com.ExamChrono.models.Entities.Surveille;

import java.util.List;

public interface SurveilleService {
    List<SurveilleDto> getAllSurveille();
    boolean addSurveille(Surveille surveille);
    boolean updateSurveille(Surveille surveille);
    boolean deleteSurveille(Long id);

    List<SurveilleDto> getAllSurveilleByIdEnseignant(Long idEnseignant);
}
