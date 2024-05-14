package com.ExamChrono.services;

import com.ExamChrono.models.Dtos.FiliereDto.FiliereDto;
import com.ExamChrono.models.Dtos.FiliereEtudiantDto.FiliereEtudiantDto;
import com.ExamChrono.models.Entities.Filiere;
import com.ExamChrono.repositories.FiliereRepository;
import com.ExamChrono.services.interfaces.FiliereEtudiantService;
import com.ExamChrono.services.interfaces.FiliereService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FiliereServiceImpl implements FiliereService {
    private final FiliereRepository filiereRepository;
    private final FiliereEtudiantService filiereEtudiantService;

    public FiliereServiceImpl(FiliereRepository filiereRepository, FiliereEtudiantService filiereEtudiantService) {
        this.filiereRepository = filiereRepository;
        this.filiereEtudiantService = filiereEtudiantService;
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
    public boolean deleteFiliere(Filiere filiere) {
        this.filiereRepository.delete(filiere);
        return true;
    }
}
