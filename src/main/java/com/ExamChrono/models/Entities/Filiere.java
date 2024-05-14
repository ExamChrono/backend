package com.ExamChrono.models.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "filiere")
public class Filiere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String specialite;
    private String niveau;
    private String NombreEtudient;

    @OneToOne
    private Delegue delegue;
    @ManyToMany(mappedBy = "filieres")
    @JsonIgnore
    private List<Etudiant> etudiants = new ArrayList<>();

    @ManyToMany(mappedBy = "filieres")
    @JsonIgnore
    private List<Groupe> groupes = new ArrayList<>();

    @ManyToMany(mappedBy = "filieres")
    @JsonIgnore
    private List<Modules> modules = new ArrayList<>();

    public void addEtudiant(Etudiant etudiant) {
        etudiants.add(etudiant);
        etudiant.getFilieres().add(this);
    }
    public void removeEtudiant(Etudiant etudiant) {
        etudiants.remove(etudiant);
        etudiant.getFilieres().remove(this);
    }

    public void addGroupe(Groupe groupe) {
        groupes.add(groupe);
        groupe.getFilieres().add(this);
    }
    public void removeGroupe(Groupe groupe) {
        groupes.remove(groupe);
        groupe.getFilieres().remove(this);
    }

    public void addModules(Modules module) {
        modules.add(module);
        module.getFilieres().add(this);
    }
    public void removeModules(Modules module) {
        modules.remove(module);
        module.getFilieres().remove(this);
    }
}
