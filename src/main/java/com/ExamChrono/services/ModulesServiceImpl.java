package com.ExamChrono.services;

import com.ExamChrono.models.Dtos.FiliereWithModulesDto.FiliereWithModulesDto;
import com.ExamChrono.models.Dtos.ModulesDto.Modules2Dto;
import com.ExamChrono.models.Dtos.ModulesDto.ModulesDto;
import com.ExamChrono.models.Entities.Filiere;
import com.ExamChrono.models.Entities.Modules;
import com.ExamChrono.repositories.FiliereRepository;
import com.ExamChrono.repositories.ModulesRepository;
import com.ExamChrono.services.interfaces.ModulesService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ModulesServiceImpl implements ModulesService {
    private final ModulesRepository modulesRepository;
    private final FiliereRepository filiereRepository;

    public ModulesServiceImpl(ModulesRepository modulesRepository, FiliereRepository filiereRepository, ModelMapper modelMapper) {
        this.modulesRepository = modulesRepository;
        this.filiereRepository = filiereRepository;
    }

    @Override
    public List<FiliereWithModulesDto> getAllModules() {
        List<Filiere> filieres = filiereRepository.findAll();
        List<FiliereWithModulesDto> dtos = new ArrayList<>();

        for (Filiere filiere : filieres) {
            List<Modules2Dto> modulesDtos = new ArrayList<>();
            for (Modules module : filiere.getModules()) {
                modulesDtos.add(new Modules2Dto(module.getId(), module.getNom(), module.getSemester(), module.getOrder()));
            }
            dtos.add(new FiliereWithModulesDto(filiere.getId(), filiere.getNom(), filiere.getSpecialite(), filiere.getNiveau(), filiere.getNombreEtudient(), modulesDtos));
        }
        return dtos;
    }

    @Override
    public boolean addModule(ModulesDto moduleDto) {

        Long filiereId = moduleDto.getFiliereId();

        Filiere filiere = this.filiereRepository.findById(filiereId).get();

        Modules module = new Modules();
        module.setNom(moduleDto.getNom());
        module.setOrder(moduleDto.getOrder());
        module.setSemester(moduleDto.getSemester());
        this.modulesRepository.save(module);

        filiere.addModules(module);
        filiere.getModules().add(module);
        this.filiereRepository.save(filiere);
        return true;
    }

    @Override
    public boolean updateModule(ModulesDto modulesDto) {
        Modules module = this.modulesRepository.findById(modulesDto.getId()).get();
        if (modulesDto.getNom() != null) module.setNom(modulesDto.getNom());
        if (modulesDto.getOrder() != 0) module.setOrder(modulesDto.getOrder());
        if (modulesDto.getSemester() != null) module.setSemester(modulesDto.getSemester());
        this.modulesRepository.save(module);
        return true;
    }

    @Override
    public boolean deleteModule(Long filiereId, Long moduleId) {

        Filiere filiere = this.filiereRepository.findById(filiereId).get();
        Modules module = this.modulesRepository.findById(moduleId).get();

        if (filiere != null && module != null){
            filiere.removeModules(module);
            this.filiereRepository.save(filiere);
            this.modulesRepository.delete(module);
            return true;
        } else {
            return false;
        }
    }
}
