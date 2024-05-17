package com.ExamChrono.services.interfaces;

import com.ExamChrono.models.Dtos.SalleDto.SalleDto;
import com.ExamChrono.models.Entities.Salle;

import java.util.List;

public interface SalleService {
    List<SalleDto> getAllSalles();
    boolean addSalle(Salle salle);
    boolean updateSalle(Salle salle);
    boolean deleteSalle(Long id);
}
