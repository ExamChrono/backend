package com.ExamChrono.repositories;

import com.ExamChrono.models.Entities.PassExamenEtudiant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PassExamenEtudiantsRepository extends JpaRepository<PassExamenEtudiant, Long> {
    List<PassExamenEtudiant> findAllByPassExamenId(Long passExamenId);
    void deleteByPassExamenId(Long passExamenId);
}
