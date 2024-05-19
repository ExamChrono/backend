package com.ExamChrono.services;

import com.ExamChrono.models.Dtos.ModulesDto.Modules2Dto;
import com.ExamChrono.models.Dtos.PassExamenDto.PassExamenDto;
import com.ExamChrono.models.Entities.Modules;
import com.ExamChrono.models.Entities.PassExamen;
import com.ExamChrono.repositories.ModulesRepository;
import com.ExamChrono.repositories.PassExamenRepository;
import com.ExamChrono.services.interfaces.PassExamenService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.ExamChrono.services.HandleDateService.*;

@Service
public class PassExamenServiceImpl implements PassExamenService {
    private final PassExamenRepository passExamenRepository;
    private final ModulesRepository modulesRepository;

    public PassExamenServiceImpl(PassExamenRepository passExamenRepository, ModulesRepository modulesRepository) {
        this.passExamenRepository = passExamenRepository;
        this.modulesRepository = modulesRepository;
    }

    @Override
    public List<PassExamenDto> getAllPassExamenEtudiants() {
        List<PassExamen> passExamens = this.passExamenRepository.findAll();
        List<PassExamenDto> dtos = new ArrayList<>();

        for (PassExamen passExamen : passExamens) {
            Long moduleId = passExamen.getModuleId();
            Modules module = this.modulesRepository.findById(moduleId).get();
            Modules2Dto moduleDto = new Modules2Dto(module.getId(), module.getNom(), module.getSemester(), module.getOrder());

            String desiredFormat = getString(passExamen.getDate());

            dtos.add(new PassExamenDto(passExamen.getId(), desiredFormat, moduleDto));
        }
        return dtos;
    }



    @Override
    public boolean addPassExamen(PassExamen passExamen) {
        this.passExamenRepository.save(passExamen);
        return true;
    }

    @Override
    public boolean updatePassExamen(PassExamen passExamen) {
        this.passExamenRepository.save(passExamen);
        return true;
    }

    @Override
    public boolean deletePassExamen(Long id) {
        this.passExamenRepository.deleteById(id);
        return true;
    }
}
