package com.ExamChrono.services;

import com.ExamChrono.models.Dtos.EtudiantDto.EtudiantDto;
import com.ExamChrono.models.Dtos.FiliereEtudiantDto.FiliereEtudiantDto;
import com.ExamChrono.models.Dtos.FiliereWithStudentsDto.FiliereWithStudentsDto;
import com.ExamChrono.models.Entities.Etudiant;
import com.ExamChrono.models.Entities.Filiere;
import com.ExamChrono.models.Enums.RoleUser;
import com.ExamChrono.repositories.EtudiantRepository;
import com.ExamChrono.repositories.FiliereRepository;
import com.ExamChrono.services.interfaces.FiliereEtudiantService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FiliereEtudiantServiceImpl implements FiliereEtudiantService {

    private final FiliereRepository filiereRepository;
    private final EtudiantRepository etudiantRepository;

    public FiliereEtudiantServiceImpl(FiliereRepository filiereRepository, EtudiantRepository etudiantRepository) {
        this.filiereRepository = filiereRepository;
        this.etudiantRepository = etudiantRepository;
    }

    @Override
    public List<FiliereWithStudentsDto> getAllFiliereEtudiant() {
        List<Filiere> filieres = filiereRepository.findAll();
        List<FiliereWithStudentsDto> dtos = new ArrayList<>();
        for (Filiere filiere : filieres) {
            List<EtudiantDto> studentDtos = new ArrayList<>();
            for (Etudiant etudiant : filiere.getEtudiants()) {
                studentDtos.add(new EtudiantDto(etudiant.getIdEtudiant(), etudiant.getMatricule(), etudiant.getEmail(), etudiant.getNom(), etudiant.getPrenom(), etudiant.getPassword(), etudiant.getValidation(), RoleUser.Etudiant));
            }
            dtos.add(new FiliereWithStudentsDto(filiere.getId(), filiere.getNom(), filiere.getSpecialite(),
                    filiere.getNiveau(), filiere.getNombreEtudient(), studentDtos));
        }
        return dtos;
    }

    @Override
    public boolean addEtudiantToFiliere(FiliereEtudiantDto filiereEtudiantDto) {

        Long filiereId = filiereEtudiantDto.getFiliereId();
        Long etudiantId = filiereEtudiantDto.getEtudiantId();

        Filiere filiere = filiereRepository.findById(filiereId).get();
        Etudiant etudiant = etudiantRepository.findById(etudiantId).get();

        if (filiere != null && etudiant != null) {
            filiere.addEtudiant(etudiant);
            filiere.getEtudiants().add(etudiant);
            filiereRepository.save(filiere);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteEtudiantFromFiliere(Long filiereId, Long etudiantId) {

        Filiere filiere = filiereRepository.findById(filiereId).get();
        Etudiant etudiant = etudiantRepository.findById(etudiantId).get();

        if (filiere != null && etudiant != null) {
            filiere.removeEtudiant(etudiant);
            filiereRepository.save(filiere);
            return true;
        } else {
            return false;
        }
    }
}
