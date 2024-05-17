package com.ExamChrono.services;

import com.ExamChrono.models.Dtos.DelegueDto.DelegueDto;
import com.ExamChrono.models.Dtos.EtudiantDto.EtudiantDto;
import com.ExamChrono.models.Entities.Delegue;
import com.ExamChrono.models.Entities.Etudiant;
import com.ExamChrono.models.Enums.RoleUser;
import com.ExamChrono.repositories.DelegueRepository;
import com.ExamChrono.repositories.EtudiantRepository;
import com.ExamChrono.services.interfaces.DelegueService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DelegueServiceImpl implements DelegueService {
    private final DelegueRepository delegueRepository;
    private final EtudiantRepository etudiantRepository;

    public DelegueServiceImpl(DelegueRepository delegueRepository, EtudiantRepository etudiantRepository) {
        this.delegueRepository = delegueRepository;
        this.etudiantRepository = etudiantRepository;
    }

    @Override
    public List<DelegueDto> getAllDelegues() {
        List<DelegueDto> delegueDtos = new ArrayList<>();
        List<Delegue> delegues = this.delegueRepository.findAll();

        for (Delegue delegue : delegues) {
            Long idEtudiant = delegue.getEtudiant().getIdEtudiant();
            Etudiant etudiant = this.etudiantRepository.findById(idEtudiant).get();
            EtudiantDto etudiantDto = new EtudiantDto(etudiant.getIdEtudiant(), etudiant.getMatricule(), etudiant.getEmail(), etudiant.getNom(), etudiant.getPrenom(), etudiant.getPassword(), etudiant.getValidation(), RoleUser.Delegue);
            delegueDtos.add(new DelegueDto(delegue.getId(), etudiantDto, RoleUser.Delegue));
        }

        return delegueDtos;
    }

    @Override
    public EtudiantDto loginDelegue(Etudiant etudiant) {
        etudiant = this.etudiantRepository.findByEmailAndPassword(etudiant.getEmail(), etudiant.getPassword());
        if (this.delegueRepository.existsByEtudiant(etudiant)){
            return new EtudiantDto(etudiant.getIdEtudiant(), etudiant.getMatricule(), etudiant.getEmail(), etudiant.getNom(), etudiant.getPrenom(), etudiant.getPassword(),etudiant.getValidation(), RoleUser.Delegue);
        }
        return new EtudiantDto();
    }

    @Override
    public boolean createDelegue(Delegue delegue) {
        delegue.setRoleUser(RoleUser.Delegue);
        this.delegueRepository.save(delegue);
        long id = delegue.getEtudiant().getIdEtudiant();
        Etudiant etudiant = this.etudiantRepository.findById(id).get();
        etudiant.setRoleUser(RoleUser.Delegue);
        this.etudiantRepository.save(etudiant);
        return true;
    }

    @Override
    public boolean deleteDelegue(Long id) {
        this.delegueRepository.deleteById(id);
        return true;
    }

    @Override
    public EtudiantDto getDelegueByEmail(Delegue delegue) {
        if (this.delegueRepository.existsByEtudiant_Email(delegue.getEtudiant().getEmail())){
            delegue = this.delegueRepository.findByEtudiant_Email(delegue.getEtudiant().getEmail());
            return new EtudiantDto(delegue.getEtudiant().getIdEtudiant(), delegue.getEtudiant().getMatricule(), delegue.getEtudiant().getEmail(), delegue.getEtudiant().getNom(), delegue.getEtudiant().getPrenom(), delegue.getEtudiant().getPassword(), delegue.getEtudiant().getValidation(), RoleUser.Delegue);
        }
        return new EtudiantDto();
    }
}
