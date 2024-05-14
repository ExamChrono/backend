package com.ExamChrono.services.interfaces;

import com.ExamChrono.models.Dtos.FiliereWithModulesDto.FiliereWithModulesDto;
import com.ExamChrono.models.Dtos.ModulesDto.ModulesDto;
import com.ExamChrono.models.Dtos.ModulesFilieredto.ModulesFilieredto;

import java.util.List;

public interface ModulesService {
    List<FiliereWithModulesDto> getAllModules();
    boolean addModule(ModulesDto modulesDto);
    boolean updateModule(ModulesDto modulesDto);
    boolean deleteModule(ModulesFilieredto modulesFilieredto);
}
