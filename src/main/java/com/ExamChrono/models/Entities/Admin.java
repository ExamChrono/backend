package com.ExamChrono.models.Entities;

import com.ExamChrono.models.Enums.RoleUser;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String nom;
    private String prenom;
    private String password;
    @Enumerated(EnumType.STRING)
    private RoleUser roleUser;
}
