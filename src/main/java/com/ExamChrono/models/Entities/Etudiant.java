package com.ExamChrono.models.Entities;

import com.ExamChrono.models.Enums.RoleUser;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "etudiant")
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEtudiant;

    private String matricule;
    private String email;
    private String nom;
    private String prenom;
    private String password;
    private Boolean validation;
    @Enumerated(EnumType.STRING)
    private RoleUser roleUser;

    @ManyToMany
    @JoinTable(name = "filiere_etudiant", joinColumns = @JoinColumn(name = "etudiant_id"), inverseJoinColumns = @JoinColumn(name = "filiere_id")    )
    private List<Filiere> filieres = new ArrayList<>();
}
