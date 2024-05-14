package com.ExamChrono.services;

import com.ExamChrono.models.Dtos.EtudiantDto.EtudiantDto;
import com.ExamChrono.models.Dtos.PassEsamenDto.PassEsamenDto;
import com.ExamChrono.models.Dtos.PassEsamenEtudiantsDto.PassEsamenEtudiantsDto;
import com.ExamChrono.models.Entities.Etudiant;
import com.ExamChrono.models.Entities.PassEsamenEtudiant;
import com.ExamChrono.repositories.EtudiantRepository;
import com.ExamChrono.repositories.ModulesRepository;
import com.ExamChrono.repositories.PassEsamenEtudiantsRepository;
import com.ExamChrono.repositories.PassEsamenRepository;
import com.ExamChrono.services.interfaces.PassEsamenEtudiantsService;
import com.ExamChrono.services.interfaces.PassEsamenService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class PassEsamenEtudiantsServiceImpl implements PassEsamenEtudiantsService {
    private final PassEsamenEtudiantsRepository passEsamenEtudiantsRepository;
    private final EtudiantRepository etudiantRepository;
    private final PassEsamenService passEsamenService;

    public PassEsamenEtudiantsServiceImpl(PassEsamenEtudiantsRepository passEsamenEtudiantsRepository, PassEsamenRepository passEsamenRepository, ModulesRepository modulesRepository, EtudiantRepository etudiantRepository, PassEsamenService passEsamenService) {
        this.passEsamenEtudiantsRepository = passEsamenEtudiantsRepository;
        this.etudiantRepository = etudiantRepository;
        this.passEsamenService = passEsamenService;
    }

    @Override
    public List<PassEsamenEtudiantsDto> getAllPassEsamenEtudiants() {

        List<PassEsamenEtudiantsDto> passEsamenEtudiantsDtos = new ArrayList<>();

        List<PassEsamenDto> passEsamenDtos = this.passEsamenService.getAllPassEsamenEtudiants();
        for (PassEsamenDto passEsamenDto : passEsamenDtos) {
            Long passEsamenId = passEsamenDto.getId();
            List<PassEsamenEtudiant> etudiantsInPassEsamen = this.passEsamenEtudiantsRepository.findAllByPassEsamenId(passEsamenId);

            if (!etudiantsInPassEsamen.isEmpty()){
                List<EtudiantDto> etudiantsDtos= new ArrayList<>();
                for (PassEsamenEtudiant etudiantInPassEsamen : etudiantsInPassEsamen) {
                    Long etudiantId = etudiantInPassEsamen.getEtudiantsId();
                    Etudiant etudiant = this.etudiantRepository.findById(etudiantId).get();
                    EtudiantDto etudiantDto = new EtudiantDto(etudiant.getIdEtudiant(), etudiant.getMatricule(), etudiant.getEmail(), etudiant.getNom(), etudiant.getPrenom(), etudiant.getPassword(), etudiant.getValidation());
                    etudiantsDtos.add(etudiantDto);
                }
                passEsamenEtudiantsDtos.add(new PassEsamenEtudiantsDto(passEsamenDto, etudiantsDtos));
            }
        }
        return passEsamenEtudiantsDtos;
    }

    @Override
    public boolean addEtudiantToPassEsamen(List<PassEsamenEtudiant> passEsamenEtudiants) {
        this.passEsamenEtudiantsRepository.saveAll(passEsamenEtudiants);
        return true;
    }

    @Transactional
    @Override
    public boolean deleteEtudiantFromPassEsamen(PassEsamenEtudiant passEsamenEtudiant) {
        this.passEsamenEtudiantsRepository.deleteByPassEsamenId(passEsamenEtudiant.getPassEsamenId());
        return true;
    }
}
