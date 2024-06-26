package com.ExamChrono.repositories;

import com.ExamChrono.models.Entities.Delegue;
import com.ExamChrono.models.Entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DelegueRepository extends JpaRepository<Delegue, Long> {
    Boolean existsByEtudiant(Etudiant etudiant);

    boolean existsByEtudiant_Email(String email);

    Delegue findByEtudiant_Email(String email);
    boolean deleteByEtudiant_IdEtudiant(Long id);
}
