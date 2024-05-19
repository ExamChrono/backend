package com.ExamChrono.services.interfaces;


import com.ExamChrono.models.Dtos.PassExamenDto.PassExamenDto;
import com.ExamChrono.models.Entities.PassExamen;

import java.util.List;

public interface PassExamenService {
    List<PassExamenDto> getAllPassExamenEtudiants();
    boolean addPassExamen(PassExamen passExamen);
    boolean updatePassExamen(PassExamen passExamen);
    boolean deletePassExamen(Long id);
}
