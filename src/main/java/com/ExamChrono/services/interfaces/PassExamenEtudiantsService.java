package com.ExamChrono.services.interfaces;


import com.ExamChrono.models.Dtos.PassExamenEtudiantsDto.PassExamenEtudiantsDto;
import com.ExamChrono.models.Entities.PassExamenEtudiant;

import java.util.List;

public interface PassExamenEtudiantsService {
    List<PassExamenEtudiantsDto> getAllPassEsamenEtudiants();
    boolean addEtudiantToPassEsamen(List<PassExamenEtudiant> passExamenEtudiants);
    boolean deleteEtudiantFromPassEsamen(Long id);
}
