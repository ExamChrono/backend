package com.ExamChrono.repositories;

import com.ExamChrono.models.Entities.PassEsamenEtudiant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PassEsamenEtudiantsRepository extends JpaRepository<PassEsamenEtudiant, Long> {
    List<PassEsamenEtudiant> findAllByPassEsamenId(Long passEsamenId);
    void deleteByPassEsamenId(Long passEsamenId);
}
