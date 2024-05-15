package com.ExamChrono.models.Dtos.EtudiantDto;

import com.ExamChrono.models.Enums.RoleUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EtudiantDto {
    private Long id;
    private String matricule;
    private String email;
    private String nom;
    private String prenom;
    private String password;
    private Boolean validation;
    private RoleUser roleUser;
}
