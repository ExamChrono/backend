package com.ExamChrono.models.Dtos.PassExamenEtudiantsDto;

import com.ExamChrono.models.Dtos.EtudiantDto.EtudiantDto;
import com.ExamChrono.models.Dtos.PassExamenDto.PassExamenDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PassExamenEtudiantsDto {
    private PassExamenDto passEsamen;
    private List<EtudiantDto> etudiants;
}
