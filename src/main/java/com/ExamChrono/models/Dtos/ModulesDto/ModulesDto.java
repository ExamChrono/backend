package com.ExamChrono.models.Dtos.ModulesDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ModulesDto {
    private long id;
    private String nom;
    private String semester;
    private long order;

    private long filiereId;
}
