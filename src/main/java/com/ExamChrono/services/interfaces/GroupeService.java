package com.ExamChrono.services.interfaces;

import com.ExamChrono.models.Dtos.FiliereWithGroupesDto.FiliereWithGroupesDto;
import com.ExamChrono.models.Dtos.GroupeDto.Groupe2Dto;
import com.ExamChrono.models.Dtos.GroupeDto.GroupeDto;

import java.util.List;

public interface GroupeService {
    List<FiliereWithGroupesDto> getAllGroupes();
    boolean addGroupe(GroupeDto groupeDto);
    boolean updateGroupe(Groupe2Dto groupeDto);
    boolean deleteGroupe(Long filiereId, Long groupeId);
}
