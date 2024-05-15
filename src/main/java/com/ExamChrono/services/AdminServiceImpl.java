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
    public Admin loginAdmin(Admin admin) {
        if (this.adminRepository.existsByEmailAndPassword(admin.getEmail(), admin.getPassword())) {
            return this.getAdmin();
        }
        return new Admin();
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

    @Override
    public Admin getAdminByEmail(Admin admin) {
        if (this.adminRepository.existsByEmail(admin.getEmail())) {
            return this.adminRepository.findByEmail(admin.getEmail());
        }
        return new Admin();
    }
}
