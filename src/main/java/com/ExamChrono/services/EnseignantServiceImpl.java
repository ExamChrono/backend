package com.ExamChrono.services;

import com.ExamChrono.models.Dtos.EnseignantDto.EnseignantDto;
import com.ExamChrono.models.Entities.Enseignant;
import com.ExamChrono.models.Enums.RoleUser;
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
    public EnseignantDto loginEnseignant(Enseignant enseignant) {
        if (this.enseignantRepository.existsByEmailAndPassword(enseignant.getEmail(), enseignant.getPassword())){
            enseignant = this.enseignantRepository.findByEmailAndPassword(enseignant.getEmail(), enseignant.getPassword());
            return new EnseignantDto(enseignant.getId(), enseignant.getEmail(), enseignant.getNom(), enseignant.getPrenom(), enseignant.getDistance(), enseignant.getAge(), enseignant.getAncien(), enseignant.isMaladie(),enseignant.getChargeCours(),enseignant.getPriorite(), enseignant.getPassword(), enseignant.getValidation(), RoleUser.Enseignant);
        }
        return new EnseignantDto();
    }

    @Override
    public boolean updateEnseignant(Enseignant enseignant) {
        this.enseignantRepository.save(enseignant);
        return true;
    }

    @Override
    public boolean createEnseignant(Enseignant enseignant, boolean validation) {
        enseignant.setValidation(validation);
        enseignant.setRoleUser(RoleUser.Enseignant);
        this.enseignantRepository.save(enseignant);
        return true;
    }

    @Override
    public boolean deleteEnseignant(Long id) {
        this.enseignantRepository.deleteById(id);
        return true;
    }

    @Override
    public EnseignantDto getEnseignantByEmail(Enseignant enseignant) {
        if (this.enseignantRepository.existsByEmail(enseignant.getEmail())){
            enseignant = this.enseignantRepository.findByEmail(enseignant.getEmail());
            return new EnseignantDto(enseignant.getId(), enseignant.getEmail(), enseignant.getNom(), enseignant.getPrenom(), enseignant.getDistance(), enseignant.getAge(), enseignant.getAncien(), enseignant.isMaladie(),enseignant.getChargeCours(),enseignant.getPriorite(), enseignant.getPassword(), enseignant.getValidation(), RoleUser.Enseignant);
        }
        return new EnseignantDto();
    }
}
