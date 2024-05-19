package com.ExamChrono.services;

import com.ExamChrono.models.Dtos.EtudiantDto.EtudiantDto;
import com.ExamChrono.models.Dtos.PassExamenDto.PassExamenDto;
import com.ExamChrono.models.Dtos.PassExamenEtudiantsDto.PassExamenEtudiantsDto;
import com.ExamChrono.models.Entities.Etudiant;
import com.ExamChrono.models.Entities.Filiere;
import com.ExamChrono.models.Entities.Modules;
import com.ExamChrono.models.Entities.PassExamenEtudiant;
import com.ExamChrono.repositories.EtudiantRepository;
import com.ExamChrono.repositories.ModulesRepository;
import com.ExamChrono.repositories.PassExamenEtudiantsRepository;
import com.ExamChrono.repositories.PassExamenRepository;
import com.ExamChrono.services.interfaces.PassExamenEtudiantsService;
import com.ExamChrono.services.interfaces.PassExamenService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class PassExamenEtudiantsServiceImpl implements PassExamenEtudiantsService {
    private final PassExamenEtudiantsRepository passExamenEtudiantsRepository;
    private final EtudiantRepository etudiantRepository;
    private final PassExamenService passExamenService;
    private final ModulesRepository modulesRepository;

    public PassExamenEtudiantsServiceImpl(PassExamenEtudiantsRepository passExamenEtudiantsRepository, PassExamenRepository passExamenRepository, ModulesRepository modulesRepository, EtudiantRepository etudiantRepository, PassExamenService passExamenService, ModulesRepository modulesRepository1) {
        this.passExamenEtudiantsRepository = passExamenEtudiantsRepository;
        this.etudiantRepository = etudiantRepository;
        this.passExamenService = passExamenService;
        this.modulesRepository = modulesRepository1;
    }

    @Override
    public List<PassExamenEtudiantsDto> getAllPassExamenEtudiants() {

        List<PassExamenEtudiantsDto> passExamenEtudiantsDtos = new ArrayList<>();

        List<PassExamenDto> passExamenDtos = this.passExamenService.getAllPassExamenEtudiants();
        for (PassExamenDto passExamenDto : passExamenDtos) {
            Long PassExamenId = passExamenDto.getId();
            List<PassExamenEtudiant> etudiantsInPassExamen = this.passExamenEtudiantsRepository.findAllByPassExamenId(PassExamenId);

            if (!etudiantsInPassExamen.isEmpty()){
                List<EtudiantDto> etudiantsDtos= new ArrayList<>();
                for (PassExamenEtudiant etudiantInPassExamen : etudiantsInPassExamen) {
                    Long etudiantId = etudiantInPassExamen.getEtudiantsId();
                    Etudiant etudiant = this.etudiantRepository.findById(etudiantId).get();
                    EtudiantDto etudiantDto = new EtudiantDto(etudiant.getIdEtudiant(), etudiant.getMatricule(), etudiant.getEmail(), etudiant.getNom(), etudiant.getPrenom(), etudiant.getPassword(), etudiant.getValidation(), etudiant.getRoleUser());
                    etudiantsDtos.add(etudiantDto);
                }
                passExamenEtudiantsDtos.add(new PassExamenEtudiantsDto(passExamenDto, etudiantsDtos));
            }
        }
        return passExamenEtudiantsDtos;
    }

    @Override
    public boolean addEtudiantToPassExamen(List<PassExamenEtudiant> passExamenEtudiants) {
        this.passExamenEtudiantsRepository.saveAll(passExamenEtudiants);
        return true;
    }

    @Transactional
    @Override
    public boolean deleteEtudiantFromPassExamen(Long id) {
        this.passExamenEtudiantsRepository.deleteByPassExamenId(id);
        return true;
    }

    @Override
    public List<EtudiantDto> getEtudiantToPassExamen(PassExamenDto passExamen) {
        List<EtudiantDto> etudiantsDtos = new ArrayList<>();
        Long moduleId = passExamen.getModules().getId();
        Modules module = this.modulesRepository.findById(moduleId).get();
        List<EtudiantDto> etudiantsDtosInFiliere = getEtudiantsDtosInFiliere(module);
        List<PassExamenEtudiant> etudiantsInPassExamen = this.passExamenEtudiantsRepository.findAllByPassExamenId(passExamen.getId());
        List<EtudiantDto> etudiantsInPassExamenDtos = new ArrayList<>();
        for (PassExamenEtudiant etudiantInPassExamen : etudiantsInPassExamen) {
            Long etudiantId = etudiantInPassExamen.getEtudiantsId();
            Etudiant etudiant = this.etudiantRepository.findById(etudiantId).get();
            EtudiantDto etudiantDto = new EtudiantDto(etudiant.getIdEtudiant(), etudiant.getMatricule(), etudiant.getEmail(), etudiant.getNom(), etudiant.getPrenom(), etudiant.getPassword(), etudiant.getValidation(), etudiant.getRoleUser());
            etudiantsInPassExamenDtos.add(etudiantDto);
        }

        for (EtudiantDto etudiantDto : etudiantsDtosInFiliere) {
            if (!etudiantsInPassExamenDtos.contains(etudiantDto)){
                etudiantsDtos.add(etudiantDto);
            }
        }

        return etudiantsDtos;
    }

    private static List<EtudiantDto> getEtudiantsDtosInFiliere(Modules module) {
        Filiere filiere = module.getFilieres().get(0);
        List<Etudiant> etudiants = filiere.getEtudiants();
        List<EtudiantDto> etudiantsDtosInFiliere = new ArrayList<>();
        for (Etudiant etudiant : etudiants) {
            EtudiantDto etudiantDto = new EtudiantDto(etudiant.getIdEtudiant(), etudiant.getMatricule(), etudiant.getEmail(), etudiant.getNom(), etudiant.getPrenom(), etudiant.getPassword(), etudiant.getValidation(), etudiant.getRoleUser());
            etudiantsDtosInFiliere.add(etudiantDto);
        }
        return etudiantsDtosInFiliere;
    }
}
