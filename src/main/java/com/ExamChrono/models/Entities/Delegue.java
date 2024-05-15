package com.ExamChrono.models.Entities;

import com.ExamChrono.models.Enums.RoleUser;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "delegue")
public class Delegue{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private RoleUser roleUser;

    @OneToOne
    private Etudiant etudiant;
}
