package com.ExamChrono.services;

import com.ExamChrono.models.Dtos.EtudiantDto.EtudiantDto;
import com.ExamChrono.models.Entities.Etudiant;
import com.ExamChrono.models.Enums.RoleUser;
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
            if (etudiant.getRoleUser() == RoleUser.Etudiant){
                dtos.add(new EtudiantDto(etudiant.getIdEtudiant(), etudiant.getMatricule(), etudiant.getEmail(), etudiant.getNom(), etudiant.getPrenom(), etudiant.getPassword(), etudiant.getValidation(), RoleUser.Etudiant));
            } else {
                dtos.add(new EtudiantDto(etudiant.getIdEtudiant(), etudiant.getMatricule(), etudiant.getEmail(), etudiant.getNom(), etudiant.getPrenom(), etudiant.getPassword(), etudiant.getValidation(), RoleUser.Delegue));
            }
        }
        return dtos;
    }

    @Override
    public EtudiantDto loginEtudiant(Etudiant etudiant) {
        if (this.etudiantRepository.existsByEmailAndPassword(etudiant.getEmail(), etudiant.getPassword())){
            etudiant = this.etudiantRepository.findByEmailAndPassword(etudiant.getEmail(), etudiant.getPassword());
            if (etudiant.getRoleUser() == RoleUser.Etudiant){
                return new EtudiantDto(etudiant.getIdEtudiant(), etudiant.getMatricule(), etudiant.getEmail(), etudiant.getNom(), etudiant.getPrenom(), etudiant.getPassword(), etudiant.getValidation(), RoleUser.Etudiant);
            } else {
                return new EtudiantDto(etudiant.getIdEtudiant(), etudiant.getMatricule(), etudiant.getEmail(), etudiant.getNom(), etudiant.getPrenom(), etudiant.getPassword(), etudiant.getValidation(), RoleUser.Delegue);
            }
        }
        return new EtudiantDto();
    }

    @Override
    public boolean updateEtudiant(Etudiant etudiant) {
        this.etudiantRepository.save(etudiant);
        return true;
    }

    @Override
    public boolean createEtudiant(Etudiant etudiant, boolean validation) {
        etudiant.setValidation(validation);
        etudiant.setRoleUser(RoleUser.Etudiant);
        this.etudiantRepository.save(etudiant);
        return true;
    }

    @Override
    public boolean deleteEtudiant(Etudiant etudiant) {
        this.etudiantRepository.delete(etudiant);
        return true;
    }

    @Override
    public EtudiantDto getEtudiantByEmail(Etudiant etudiant) {
        if (this.etudiantRepository.existsByEmail(etudiant.getEmail())){
            etudiant = this.etudiantRepository.findByEmail(etudiant.getEmail());
            if (etudiant.getRoleUser() == RoleUser.Etudiant){
                return new EtudiantDto(etudiant.getIdEtudiant(), etudiant.getMatricule(), etudiant.getEmail(), etudiant.getNom(), etudiant.getPrenom(), etudiant.getPassword(), etudiant.getValidation(), RoleUser.Etudiant);
            } else {
                return new EtudiantDto(etudiant.getIdEtudiant(), etudiant.getMatricule(), etudiant.getEmail(), etudiant.getNom(), etudiant.getPrenom(), etudiant.getPassword(), etudiant.getValidation(), RoleUser.Delegue);
            }
        }
        return new EtudiantDto();
    }
}
