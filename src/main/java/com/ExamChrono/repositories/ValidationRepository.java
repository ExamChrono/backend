package com.ExamChrono.repositories;

import com.ExamChrono.models.Entities.Validation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ValidationRepository extends JpaRepository<Validation, Long> {
    Boolean existsByCodeAndEmail(Long code, String email);
}
