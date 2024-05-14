package com.ExamChrono.models.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "modules")
public class Modules {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String semester;
    @Column(name = "`order`")
    private Long order;

    @ManyToMany
    @JoinTable(name = "filiere_modules", joinColumns = @JoinColumn(name = "filiere_id"), inverseJoinColumns = @JoinColumn(name = "modules_id"))
    private List<Filiere> filieres = new ArrayList<>();
}
