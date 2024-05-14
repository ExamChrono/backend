package com.ExamChrono.services.interfaces;


import com.ExamChrono.models.Dtos.PassEsamenEtudiantsDto.PassEsamenEtudiantsDto;
import com.ExamChrono.models.Entities.PassEsamenEtudiant;

import java.util.List;

public interface PassEsamenEtudiantsService {
    List<PassEsamenEtudiantsDto> getAllPassEsamenEtudiants();
    boolean addEtudiantToPassEsamen(List<PassEsamenEtudiant> passEsamenEtudiants);
    boolean deleteEtudiantFromPassEsamen(PassEsamenEtudiant passEsamenEtudiants);
}
