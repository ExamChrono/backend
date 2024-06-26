package com.ExamChrono.services;

import com.ExamChrono.models.Dtos.FiliereDto.FiliereDto;
import com.ExamChrono.models.Dtos.GroupeDto.Groupe3Dto;
import com.ExamChrono.models.Dtos.ModulesDto.Modules2Dto;
import com.ExamChrono.models.Dtos.PassExamenDto.PassExamenDto;
import com.ExamChrono.models.Dtos.SalleDto.SalleDto;
import com.ExamChrono.models.Dtos.SurveilleDto.SurveilleDto;
import com.ExamChrono.models.Entities.*;
import com.ExamChrono.repositories.*;
import com.ExamChrono.services.interfaces.SalleService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.ExamChrono.services.HandleDateService.getString;
import static com.ExamChrono.services.SurveilleServiceImpl.getFiliereDto;

@Service
public class SalleServiceImpl implements SalleService {
    private final SalleRepository salleRepository;
    private final SurveilleRepository surveilleRepository;
    private final GroupeRepository groupeRepository;
    private final EnseignantRepository enseignantRepository;
    private final PassExamenRepository passExamenRepository;
    private final ModulesRepository modulesRepository;

    public SalleServiceImpl(SalleRepository salleRepository, SurveilleRepository surveilleRepository, GroupeRepository groupeRepository, EnseignantRepository enseignantRepository, PassExamenRepository passExamenRepository, ModulesRepository modulesRepository) {
        this.salleRepository = salleRepository;
        this.surveilleRepository = surveilleRepository;
        this.groupeRepository = groupeRepository;
        this.enseignantRepository = enseignantRepository;
        this.passExamenRepository = passExamenRepository;
        this.modulesRepository = modulesRepository;
    }

    @Override
    public List<SalleDto> getAllSalles() {
        List<SalleDto> salleDtos = new ArrayList<>();
        List<Salle> salles = this.salleRepository.findAll();

        for (Salle salle : salles) {
            Long surveilleId = salle.getSurveilleId();
            Surveille surveille = this.surveilleRepository.findById(surveilleId).orElse(null);

            Long groupeId = surveille.getGroupeId();

            Groupe groupe = this.groupeRepository.findById(groupeId).get();
            long nbrEtudiant = groupe.getNbrEtudiant();

            FiliereDto filiereDto = getFiliereDto(groupe);

            Groupe3Dto groupe3Dto = new Groupe3Dto(groupeId, nbrEtudiant, filiereDto);

            Long enseignantId = surveille.getEnseignantId();
            Enseignant enseignant = this.enseignantRepository.findById(enseignantId).get();

            SurveilleDto surveilleDto = new SurveilleDto();
            surveilleDto.setId(surveille.getId());
            surveilleDto.setNom(surveille.getNom());
            surveilleDto.setCode(surveille.getCode());
            surveilleDto.setGroupe(groupe3Dto);
            surveilleDto.setEnseignant(enseignant);

            Long PassExamenId = salle.getPassExamenId();
            PassExamen passExamen = this.passExamenRepository.findById(PassExamenId).orElse(null);

            Long moduleId = passExamen.getModuleId();
            Modules module = this.modulesRepository.findById(moduleId).get();
            Modules2Dto moduleDto = new Modules2Dto(module.getId(), module.getNom(), module.getSemester(), module.getOrder());

            String desiredFormat = getString(passExamen.getDate());

            PassExamenDto passExamenDto = new PassExamenDto(passExamen.getId(), desiredFormat, moduleDto);

            SalleDto salleDto = new SalleDto();
            salleDto.setId(salle.getId());
            salleDto.setNumero_salle(salle.getNumero_salle());
            salleDto.setType_salle(salle.getType_salle());
            salleDto.setCapacite(salle.getCapacite());
            salleDto.setSurveille(surveilleDto);
            salleDto.setPassExamen(passExamenDto);

            salleDtos.add(salleDto);
        }

        return salleDtos;
    }

    @Override
    public boolean addSalle(Salle salle) {
        this.salleRepository.save(salle);
        return true;
    }

    @Override
    public boolean updateSalle(Salle salle) {
        this.salleRepository.save(salle);
        return true;
    }

    @Override
    public boolean deleteSalle(Long id) {
        this.salleRepository.deleteById(id);
        return true;
    }
}
