package com.ExamChrono.services.interfaces;


import com.ExamChrono.models.Dtos.EtudiantDto.EtudiantDto;
import com.ExamChrono.models.Dtos.PassExamenDto.PassExamenDto;
import com.ExamChrono.models.Dtos.PassExamenEtudiantsDto.PassExamenEtudiantsDto;
import com.ExamChrono.models.Entities.PassExamenEtudiant;

import java.util.List;

public interface PassExamenEtudiantsService {
    List<PassExamenEtudiantsDto> getAllPassExamenEtudiants();
    boolean addEtudiantToPassExamen(List<PassExamenEtudiant> passExamenEtudiants);
    boolean deleteEtudiantFromPassExamen(Long id);

    List<EtudiantDto> getEtudiantToPassExamen(PassExamenDto passExamen);
}
