package com.ExamChrono.services.interfaces;

import com.ExamChrono.models.Dtos.FiliereWithModulesDto.FiliereWithModulesDto;
import com.ExamChrono.models.Dtos.ModulesDto.ModulesDto;

import java.util.List;

public interface ModulesService {
    List<FiliereWithModulesDto> getAllModules();
    boolean addModule(ModulesDto modulesDto);
    boolean updateModule(ModulesDto modulesDto);
    boolean deleteModule(Long filiereId, Long moduleId);
}
