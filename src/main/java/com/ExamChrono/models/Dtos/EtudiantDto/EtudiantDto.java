package com.ExamChrono.models.Dtos.EtudiantDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EtudiantDto {
    private Long idEtudiant;
    private String matricule;
    private String email;
    private String nom;
    private String prenom;
    private String password;
    private Boolean validation;
}
