package com.ExamChrono.models.Dtos.PassEsamenEtudiantsDto;

import com.ExamChrono.models.Dtos.EtudiantDto.EtudiantDto;
import com.ExamChrono.models.Dtos.PassEsamenDto.PassEsamenDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PassEsamenEtudiantsDto {
    private PassEsamenDto passEsamen;
    private List<EtudiantDto> etudiants;
}
