package com.ExamChrono.services.interfaces;

import com.ExamChrono.models.Entities.Admin;

public interface AdminService {
    Admin loginAdmin(Admin admin);
    boolean updateAdmin(Admin admin);
    Admin getAdmin();

    Admin getAdminByEmail(Admin admin);
}
