package com.ExamChrono.services;

import com.ExamChrono.models.Entities.Admin;
import com.ExamChrono.repositories.AdminRepository;
import com.ExamChrono.services.interfaces.AdminService;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    private final AdminRepository adminRepository;

    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public boolean loginAdmin(Admin admin) {
        return this.adminRepository.existsByEmailAndPassword(admin.getEmail(), admin.getPassword());
    }

    @Override
    public boolean updateAdmin(Admin admin) {
        this.adminRepository.save(admin);
        return true;
    }

    @Override
    public Admin getAdmin() {
        return this.adminRepository.findAll().getFirst();
    }
}
