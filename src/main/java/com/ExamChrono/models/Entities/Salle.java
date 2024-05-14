package com.ExamChrono.models.Entities;

import com.ExamChrono.models.Enums.TypeSalle;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "salle")
public class Salle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long numero_salle;
    @Enumerated(EnumType.STRING)
    private TypeSalle type_salle;
    private Long capacite;

    private Long passEsamenId;
    private Long surveilleId;
}
