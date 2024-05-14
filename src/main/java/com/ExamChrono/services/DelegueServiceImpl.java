package com.ExamChrono.services;

import com.ExamChrono.models.Entities.Delegue;
import com.ExamChrono.models.Entities.Etudiant;
import com.ExamChrono.repositories.DelegueRepository;
import com.ExamChrono.repositories.EtudiantRepository;
import com.ExamChrono.services.interfaces.DelegueService;
import org.springframework.stereotype.Service;

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
    public List<Delegue> getAllDelegues() {
        return this.delegueRepository.findAll();
    }

    @Override
    public boolean loginDelegue(Etudiant etudiant) {
        etudiant = this.etudiantRepository.findByEmailAndPassword(etudiant.getEmail(), etudiant.getPassword());
        return this.delegueRepository.existsByEtudiant(etudiant);
    }

    @Override
    public boolean createDelegue(Delegue delegue) {
        this.delegueRepository.save(delegue);
        return true;
    }

    @Override
    public boolean deleteDelegue(Delegue delegue) {
        this.delegueRepository.delete(delegue);
        return true;
    }
}
