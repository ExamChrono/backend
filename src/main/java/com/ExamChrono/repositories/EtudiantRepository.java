package com.ExamChrono.repositories;

import com.ExamChrono.models.Entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
    boolean existsByEmailAndPassword(String email, String password);

    Etudiant findByEmailAndPassword(String email, String password);
}
