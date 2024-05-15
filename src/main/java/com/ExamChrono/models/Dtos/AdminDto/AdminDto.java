package com.ExamChrono.models.Dtos.AdminDto;

import com.ExamChrono.models.Enums.RoleUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AdminDto {
    private Long id;
    private String email;
    private String nom;
    private String prenom;
    private String password;
    private RoleUser roleUser;
}
