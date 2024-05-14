package com.ExamChrono.services;

import com.ExamChrono.models.Dtos.FiliereWithGroupesDto.FiliereWithGroupesDto;
import com.ExamChrono.models.Dtos.GroupeDto.Groupe2Dto;
import com.ExamChrono.models.Dtos.GroupeDto.GroupeDto;
import com.ExamChrono.models.Dtos.GroupeFiliereDto.GroupeFiliereDto;
import com.ExamChrono.models.Entities.Filiere;
import com.ExamChrono.models.Entities.Groupe;
import com.ExamChrono.repositories.FiliereRepository;
import com.ExamChrono.repositories.GroupeRepository;
import com.ExamChrono.services.interfaces.GroupeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupeServiceImpl implements GroupeService {
    private final GroupeRepository groupeRepository;
    private final FiliereRepository filiereRepository;

    public GroupeServiceImpl(GroupeRepository groupeRepository, FiliereRepository filiereRepository) {
        this.groupeRepository = groupeRepository;
        this.filiereRepository = filiereRepository;
    }

    @Override
    public List<FiliereWithGroupesDto> getAllGroupes() {
        List<Filiere> filieres = filiereRepository.findAll();
        List<FiliereWithGroupesDto> dtos = new ArrayList<>();

        for (Filiere filiere : filieres) {
            List<Groupe2Dto> groupeDtos = new ArrayList<>();
            for (Groupe groupe : filiere.getGroupes()) {
                groupeDtos.add(new Groupe2Dto(groupe.getId(), groupe.getNbrEtudiant()));
            }
            dtos.add(new FiliereWithGroupesDto(filiere.getId(), filiere.getNom(), filiere.getSpecialite(), filiere.getNiveau(), filiere.getNombreEtudient(), groupeDtos));
        }

        return dtos;
    }

    @Override
    public boolean addGroupe(GroupeDto groupeDto) {

        Long filiereId = groupeDto.getFiliereId();
        Long nbrEtudiant = groupeDto.getNbrEtudiant();

        Filiere filiere = this.filiereRepository.findById(filiereId).get();

        Groupe groupe = new Groupe();
        groupe.setNbrEtudiant(nbrEtudiant);
        this.groupeRepository.save(groupe);

        filiere.addGroupe(groupe);
        filiere.getGroupes().add(groupe);
        this.filiereRepository.save(filiere);
        return true;
    }

    @Override
    public boolean updateGroupe(Groupe2Dto groupeDto) {
        Groupe groupe = this.groupeRepository.findById(groupeDto.getId()).get();
        groupe.setNbrEtudiant(groupeDto.getNbrEtudiant());
        this.groupeRepository.save(groupe);
        return true;
    }

    @Override
    public boolean deleteGroupe(GroupeFiliereDto groupeFiliereDto) {
        long filiereId = groupeFiliereDto.getFiliereId();
        long groupeId = groupeFiliereDto.getGroupeId();

        Filiere filiere = this.filiereRepository.findById(filiereId).get();
        Groupe groupe = this.groupeRepository.findById(groupeId).get();

        if (filiere != null && groupe != null) {
            filiere.removeGroupe(groupe);
            filiereRepository.save(filiere);
            groupeRepository.delete(groupe);
            return true;
        } else {
            return false;
        }
    }
}
