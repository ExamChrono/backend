package com.ExamChrono.services;

import com.ExamChrono.models.Dtos.FiliereDto.FiliereDto;
import com.ExamChrono.models.Dtos.FiliereEtudiantDto.FiliereEtudiantDto;
import com.ExamChrono.models.Entities.Etudiant;
import com.ExamChrono.models.Entities.Filiere;
import com.ExamChrono.models.Entities.Groupe;
import com.ExamChrono.models.Entities.Modules;
import com.ExamChrono.repositories.FiliereRepository;
import com.ExamChrono.services.interfaces.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FiliereServiceImpl implements FiliereService {
    private final FiliereRepository filiereRepository;
    private final FiliereEtudiantService filiereEtudiantService;
    private final ModulesService modulesService;
    private final GroupeService groupeService;

    public FiliereServiceImpl(FiliereRepository filiereRepository, FiliereEtudiantService filiereEtudiantService, DelegueService delegueService, ModulesService modulesService, GroupeService groupeService) {
        this.filiereRepository = filiereRepository;
        this.filiereEtudiantService = filiereEtudiantService;
        this.modulesService = modulesService;
        this.groupeService = groupeService;
    }

    @Override
    public List<FiliereDto> getAllFilieres() {
        List<Filiere> filieres = filiereRepository.findAll();
        List<FiliereDto> dtos = new ArrayList<>();
        for (Filiere filiere : filieres) {
            dtos.add(new FiliereDto(filiere.getId(), filiere.getNom(), filiere.getSpecialite(), filiere.getNiveau(), filiere.getNombreEtudient()));
        }
        return dtos;
    }

    @Override
    public boolean updateFiliere(Filiere filiere) {
        this.filiereRepository.save(filiere);
        return true;
    }

    @Override
    public boolean createFiliere(Filiere filiere) {
        this.filiereRepository.save(filiere);
        Long filiereId = filiere.getId();
        Long delegueId = filiere.getDelegue().getId();

        FiliereEtudiantDto filiereEtudiantDto = new FiliereEtudiantDto();
        filiereEtudiantDto.setFiliereId(filiereId);
        filiereEtudiantDto.setEtudiantId(delegueId);

        this.filiereEtudiantService.addEtudiantToFiliere(filiereEtudiantDto);
        return true;
    }

    @Override
    public boolean deleteFiliere(Long id) {
        Optional<Filiere> optionalFiliere = this.filiereRepository.findById(id);

        if (optionalFiliere.isPresent()) {
            Filiere filiere = optionalFiliere.get();
            List<Modules> modules = filiere.getModules();
            if (!modules.isEmpty()) {
                for (Modules module : modules) {
                    filiere.removeModules(module);
                    filiereRepository.save(filiere);
                }
            }
            List<Groupe> groupes = filiere.getGroupes();
            if (!groupes.isEmpty()) {
                for (Groupe groupe : groupes) {
                    filiere.removeGroupe(groupe);
                    filiereRepository.save(filiere);
                }
            }
            List<Etudiant> etudiants = filiere.getEtudiants();
            if (!etudiants.isEmpty()) {
                for (Etudiant etudiant : etudiants) {
                    filiere.removeEtudiant(etudiant);
                    filiereRepository.save(filiere);
                }
            }
            this.filiereRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
