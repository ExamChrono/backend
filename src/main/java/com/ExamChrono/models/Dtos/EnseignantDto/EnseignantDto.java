package com.ExamChrono.models.Dtos.EnseignantDto;

import com.ExamChrono.models.Enums.RoleUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnseignantDto {
    private Long id;
    private String email;
    private String nom;
    private String prenom;
    private String distance;
    private long age;
    private boolean ancien;
    private boolean maladie;
    private boolean chargeCours;
    private boolean priorite;
    private String password;
    private Boolean validation;
    private RoleUser roleUser;
}
