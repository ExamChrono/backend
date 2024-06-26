package com.ExamChrono.models.Dtos.SalleDto;

import com.ExamChrono.models.Dtos.PassExamenDto.PassExamenDto;
import com.ExamChrono.models.Dtos.SurveilleDto.SurveilleDto;
import com.ExamChrono.models.Enums.TypeSalle;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SalleDto {
    private Long id;
    private Long numero_salle;
    private TypeSalle type_salle;
    private Long capacite;

    private PassExamenDto passExamen;
    private SurveilleDto surveille;
}
