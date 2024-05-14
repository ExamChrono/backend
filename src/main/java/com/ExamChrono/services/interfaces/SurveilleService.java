package com.ExamChrono.services.interfaces;

import com.ExamChrono.models.Dtos.SurveilleDto.SurveilleDto;
import com.ExamChrono.models.Entities.Surveille;

import java.util.List;

public interface SurveilleService {
    List<SurveilleDto> getAllSurveille();
    boolean addSurveille(Surveille surveille);
    boolean updateSurveille(Surveille surveille);
    boolean deleteSurveille(Surveille surveille);
}
