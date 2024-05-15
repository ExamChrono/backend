package com.ExamChrono.repositories;

import com.ExamChrono.models.Entities.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnseignantRepository extends JpaRepository<Enseignant, Long> {
    boolean existsByEmailAndPassword(String email, String password);

    Enseignant findByEmailAndPassword(String email, String password);

    boolean existsByEmail(String email);

    Enseignant findByEmail(String email);
}
