package com.ExamChrono.services.interfaces;


import com.ExamChrono.models.Dtos.PassExamenDto.PassExamenDto;
import com.ExamChrono.models.Entities.PassExamen;

import java.util.List;

public interface PassExamenService {
    List<PassExamenDto> getAllPassEsamenEtudiants();
    boolean addPassEsamen(PassExamen passExamen);
    boolean updatePassEsamen(PassExamen passExamen);
    boolean deletePassEsamen(Long id);
}
