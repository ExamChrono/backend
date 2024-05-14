package com.ExamChrono.repositories;

import com.ExamChrono.models.Entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    boolean existsByEmailAndPassword(String email, String password);
}
