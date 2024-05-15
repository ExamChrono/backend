package com.ExamChrono;

import com.ExamChrono.models.Entities.Admin;
import com.ExamChrono.models.Enums.RoleUser;
import com.ExamChrono.repositories.AdminRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ExamChrono {
    public static void main(String[] args) {
        SpringApplication.run(ExamChrono.class, args);
    }
    @Bean
    CommandLineRunner start(AdminRepository adminRepository){
        return args -> {
            Admin admin = new Admin();
            admin.setId(1L);
            admin.setEmail("loubnarachid1717@gmail.com");
            admin.setPassword("admin");
            admin.setNom("Rachid");
            admin.setPrenom("Loubna");
            admin.setRoleUser(RoleUser.Admin);
            adminRepository.save(admin);
        };
    }
}