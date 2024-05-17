package com.ExamChrono.models.Dtos.PassExamenDto;

import com.ExamChrono.models.Dtos.ModulesDto.Modules2Dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PassExamenDto {
    private Long id;
    private String date;

    private Modules2Dto modules;
}
