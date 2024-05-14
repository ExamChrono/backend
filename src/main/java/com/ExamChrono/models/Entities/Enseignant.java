package com.ExamChrono.models.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "enseignant")
public class Enseignant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
}
