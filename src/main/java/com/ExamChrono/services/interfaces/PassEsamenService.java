package com.ExamChrono.services.interfaces;


import com.ExamChrono.models.Dtos.PassEsamenDto.PassEsamenDto;
import com.ExamChrono.models.Entities.PassEsamen;

import java.util.List;

public interface PassEsamenService {
    List<PassEsamenDto> getAllPassEsamenEtudiants();
    boolean addPassEsamen(PassEsamen passEsamen);
    boolean updatePassEsamen(PassEsamen passEsamen);
    boolean deletePassEsamen(PassEsamen passEsamen);
}
