package com.ExamChrono.services;

import com.ExamChrono.models.Dtos.EtudiantDto.EtudiantDto;
import com.ExamChrono.models.Entities.Etudiant;
import com.ExamChrono.repositories.EtudiantRepository;
import com.ExamChrono.services.interfaces.EtudiantService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtudiantServiceImpl implements EtudiantService {
    private final EtudiantRepository etudiantRepository;

    public EtudiantServiceImpl(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }

    @Override
    public List<EtudiantDto> getAllEtudiants() {
        List<Etudiant> etudiants = this.etudiantRepository.findAll();
        List<EtudiantDto> dtos = new java.util.ArrayList<>();
        for (Etudiant etudiant : etudiants) {
            dtos.add(new EtudiantDto(etudiant.getIdEtudiant(), etudiant.getMatricule(), etudiant.getNom(), etudiant.getPrenom(), etudiant.getEmail(), etudiant.getPassword(), etudiant.getValidation()));
        }
        return dtos;
    }

    @Override
    public boolean loginEtudiant(Etudiant etudiant) {
        return this.etudiantRepository.existsByEmailAndPassword(etudiant.getEmail(), etudiant.getPassword());
    }

    @Override
    public boolean updateEtudiant(Etudiant etudiant) {
        this.etudiantRepository.save(etudiant);
        return true;
    }

    @Override
    public boolean createEtudiant(Etudiant etudiant, boolean validation) {
        etudiant.setValidation(validation);
        this.etudiantRepository.save(etudiant);
        return true;
    }

    @Override
    public boolean deleteEtudiant(Etudiant etudiant) {
        this.etudiantRepository.delete(etudiant);
        return true;
    }
}
