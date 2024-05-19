package com.ExamChrono.services;

import com.ExamChrono.models.Dtos.FiliereDto.FiliereDto;
import com.ExamChrono.models.Dtos.GroupeDto.Groupe3Dto;
import com.ExamChrono.models.Dtos.SurveilleDto.SurveilleDto;
import com.ExamChrono.models.Entities.Enseignant;
import com.ExamChrono.models.Entities.Groupe;
import com.ExamChrono.models.Entities.Salle;
import com.ExamChrono.models.Entities.Surveille;
import com.ExamChrono.repositories.*;
import com.ExamChrono.services.interfaces.SurveilleService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SurveilleServiceImpl implements SurveilleService {
    private final SurveilleRepository surveilleRepository;
    private final GroupeRepository groupeRepository;
    private final EnseignantRepository enseignantRepository;
    private final SalleRepository salleRepository;

    public SurveilleServiceImpl(SurveilleRepository surveilleRepository, GroupeRepository groupeRepository, FiliereRepository filiereRepository, EnseignantRepository enseignantRepository, SalleRepository salleRepository) {
        this.surveilleRepository = surveilleRepository;
        this.groupeRepository = groupeRepository;
        this.enseignantRepository = enseignantRepository;
        this.salleRepository = salleRepository;
    }

    @Override
    public List<SurveilleDto> getAllSurveille() {
        List<SurveilleDto> surveilleDtos = new ArrayList<>();
        List<Surveille> surveilles = this.surveilleRepository.findAll();

        return getSurveilleDtos(surveilleDtos, surveilles);
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
    public boolean deleteSurveille(Long id) {
        Salle salle = this.salleRepository.findBySurveilleId(id);
        this.salleRepository.delete(salle);
        this.surveilleRepository.deleteById(id);
        return true;
    }

    @Override
    public List<SurveilleDto> getAllSurveilleByIdEnseignant(Long idEnseignant) {
        List<SurveilleDto> surveilleDtos = new ArrayList<>();
        List<Surveille> surveilles = this.surveilleRepository.findAllByEnseignantId(idEnseignant);

        return getSurveilleDtos(surveilleDtos, surveilles);
    }

    private List<SurveilleDto> getSurveilleDtos(List<SurveilleDto> surveilleDtos, List<Surveille> surveilles) {
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
}
