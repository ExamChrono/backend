package com.ExamChrono.services;

import com.ExamChrono.models.Dtos.EtudiantDto.EtudiantDto;
import com.ExamChrono.models.Dtos.PassExamenDto.PassExamenDto;
import com.ExamChrono.models.Dtos.PassExamenEtudiantsDto.PassExamenEtudiantsDto;
import com.ExamChrono.models.Entities.Etudiant;
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

    public PassExamenEtudiantsServiceImpl(PassExamenEtudiantsRepository passExamenEtudiantsRepository, PassExamenRepository passExamenRepository, ModulesRepository modulesRepository, EtudiantRepository etudiantRepository, PassExamenService passExamenService) {
        this.passExamenEtudiantsRepository = passExamenEtudiantsRepository;
        this.etudiantRepository = etudiantRepository;
        this.passExamenService = passExamenService;
    }

    @Override
    public List<PassExamenEtudiantsDto> getAllPassEsamenEtudiants() {

        List<PassExamenEtudiantsDto> passExamenEtudiantsDtos = new ArrayList<>();

        List<PassExamenDto> passExamenDtos = this.passExamenService.getAllPassEsamenEtudiants();
        for (PassExamenDto passExamenDto : passExamenDtos) {
            Long passEsamenId = passExamenDto.getId();
            List<PassExamenEtudiant> etudiantsInPassEsamen = this.passExamenEtudiantsRepository.findAllByPassEsamenId(passEsamenId);

            if (!etudiantsInPassEsamen.isEmpty()){
                List<EtudiantDto> etudiantsDtos= new ArrayList<>();
                for (PassExamenEtudiant etudiantInPassEsamen : etudiantsInPassEsamen) {
                    Long etudiantId = etudiantInPassEsamen.getEtudiantsId();
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
    public boolean addEtudiantToPassEsamen(List<PassExamenEtudiant> passExamenEtudiants) {
        this.passExamenEtudiantsRepository.saveAll(passExamenEtudiants);
        return true;
    }

    @Transactional
    @Override
    public boolean deleteEtudiantFromPassEsamen(Long id) {
        this.passExamenEtudiantsRepository.deleteByPassEsamenId(id);
        return true;
    }
}
