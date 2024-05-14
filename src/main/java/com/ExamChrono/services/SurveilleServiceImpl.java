package com.ExamChrono.services;

import com.ExamChrono.models.Dtos.FiliereDto.FiliereDto;
import com.ExamChrono.models.Dtos.GroupeDto.Groupe3Dto;
import com.ExamChrono.models.Dtos.SurveilleDto.SurveilleDto;
import com.ExamChrono.models.Entities.Enseignant;
import com.ExamChrono.models.Entities.Groupe;
import com.ExamChrono.models.Entities.Surveille;
import com.ExamChrono.repositories.EnseignantRepository;
import com.ExamChrono.repositories.FiliereRepository;
import com.ExamChrono.repositories.GroupeRepository;
import com.ExamChrono.repositories.SurveilleRepository;
import com.ExamChrono.services.interfaces.SurveilleService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SurveilleServiceImpl implements SurveilleService {
    private final SurveilleRepository surveilleRepository;
    private final GroupeRepository groupeRepository;
    private final EnseignantRepository enseignantRepository;

    public SurveilleServiceImpl(SurveilleRepository surveilleRepository, GroupeRepository groupeRepository, FiliereRepository filiereRepository, EnseignantRepository enseignantRepository) {
        this.surveilleRepository = surveilleRepository;
        this.groupeRepository = groupeRepository;
        this.enseignantRepository = enseignantRepository;
    }

    @Override
    public List<SurveilleDto> getAllSurveille() {
        List<SurveilleDto> surveilleDtos = new ArrayList<>();
        List<Surveille> surveilles = this.surveilleRepository.findAll();

       for (Surveille surveille : surveilles) {
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

            surveilleDtos.add(surveilleDto);
        }

        return surveilleDtos;
    }

    static FiliereDto getFiliereDto(Groupe groupe) {
        long filiereId = groupe.getFilieres().get(0).getId();
        String filierNom = groupe.getFilieres().get(0).getNom();
        String filiereSpecialite = groupe.getFilieres().get(0).getSpecialite();
        String filiereNiveau = groupe.getFilieres().get(0).getNiveau();
        String filiereNombreEtudient = groupe.getFilieres().get(0).getNombreEtudient();

        FiliereDto filiereDto = new FiliereDto(filiereId, filierNom, filiereSpecialite, filiereNiveau, filiereNombreEtudient);
        return filiereDto;
    }

    @Override
    public boolean addSurveille(Surveille surveille) {
        this.surveilleRepository.save(surveille);
        return true;
    }

    @Override
    public boolean updateSurveille(Surveille surveille) {
        this.surveilleRepository.save(surveille);
        return true;
    }

    @Override
    public boolean deleteSurveille(Surveille surveille) {
        this.surveilleRepository.delete(surveille);
        return true;
    }
}
