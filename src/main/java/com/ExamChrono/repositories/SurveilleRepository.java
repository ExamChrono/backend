package com.ExamChrono.repositories;

import com.ExamChrono.models.Entities.Surveille;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SurveilleRepository extends JpaRepository<Surveille, Long> {
    List<Surveille> findAllByEnseignantId(Long id);
}
