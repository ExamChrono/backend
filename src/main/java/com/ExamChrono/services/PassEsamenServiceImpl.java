package com.ExamChrono.services;

import com.ExamChrono.models.Dtos.ModulesDto.Modules2Dto;
import com.ExamChrono.models.Dtos.PassEsamenDto.PassEsamenDto;
import com.ExamChrono.models.Entities.Modules;
import com.ExamChrono.models.Entities.PassEsamen;
import com.ExamChrono.repositories.ModulesRepository;
import com.ExamChrono.repositories.PassEsamenRepository;
import com.ExamChrono.services.interfaces.PassEsamenService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.ExamChrono.services.HandleDateService.*;

@Service
public class PassEsamenServiceImpl implements PassEsamenService {
    private final PassEsamenRepository passEsamenRepository;
    private final ModulesRepository modulesRepository;

    public PassEsamenServiceImpl(PassEsamenRepository passEsamenRepository, ModulesRepository modulesRepository) {
        this.passEsamenRepository = passEsamenRepository;
        this.modulesRepository = modulesRepository;
    }

    @Override
    public List<PassEsamenDto> getAllPassEsamenEtudiants() {
        List<PassEsamen> passEsamens = this.passEsamenRepository.findAll();
        List<PassEsamenDto> dtos = new ArrayList<>();

        for (PassEsamen passEsamen : passEsamens) {
            Long moduleId = passEsamen.getModuleId();
            Modules module = this.modulesRepository.findById(moduleId).get();
            Modules2Dto moduleDto = new Modules2Dto(module.getId(), module.getNom(), module.getSemester(), module.getOrder());

            String desiredFormat = getString(passEsamen.getDate());

            dtos.add(new PassEsamenDto(passEsamen.getId(), desiredFormat, moduleDto));
        }
        return dtos;
    }



    @Override
    public boolean addPassEsamen(PassEsamen passEsamen) {
        this.passEsamenRepository.save(passEsamen);
        return true;
    }

    @Override
    public boolean updatePassEsamen(PassEsamen passEsamen) {
        this.passEsamenRepository.save(passEsamen);
        return true;
    }

    @Override
    public boolean deletePassEsamen(PassEsamen passEsamen) {
        this.passEsamenRepository.delete(passEsamen);
        return true;
    }
}
