package com.ExamChrono.services;

import com.ExamChrono.models.Entities.Enseignant;
import com.ExamChrono.repositories.EnseignantRepository;
import com.ExamChrono.services.interfaces.EnseignantService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnseignantServiceImpl implements EnseignantService {
    private final EnseignantRepository enseignantRepository;

    public EnseignantServiceImpl(EnseignantRepository enseignantRepository) {
        this.enseignantRepository = enseignantRepository;
    }

    @Override
    public List<Enseignant> getAllEnseignants() {
        return this.enseignantRepository.findAll();
    }

    @Override
    public boolean loginEnseignant(Enseignant enseignant) {
        return this.enseignantRepository.existsByEmailAndPassword(enseignant.getEmail(), enseignant.getPassword());
    }

    @Override
    public boolean updateEnseignant(Enseignant enseignant) {
        this.enseignantRepository.save(enseignant);
        return true;
    }

    @Override
    public boolean createEnseignant(Enseignant enseignant, boolean validation) {
        enseignant.setValidation(validation);
        this.enseignantRepository.save(enseignant);
        return true;
    }

    @Override
    public boolean deleteEnseignant(Enseignant enseignant) {
        this.enseignantRepository.delete(enseignant);
        return true;
    }
}
