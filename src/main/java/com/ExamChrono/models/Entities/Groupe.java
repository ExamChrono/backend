package com.ExamChrono.models.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "groupe")
public class Groupe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long nbrEtudiant;

    @ManyToMany
    @JoinTable(name = "filiere_groupe", joinColumns = @JoinColumn(name = "filiere_id"), inverseJoinColumns = @JoinColumn(name = "groupe_id"))
    private List<Filiere> filieres = new ArrayList<>();
}
