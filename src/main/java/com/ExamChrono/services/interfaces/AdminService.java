package com.ExamChrono.services.interfaces;

import com.ExamChrono.models.Entities.Admin;

public interface AdminService {
    boolean loginAdmin(Admin admin);
    boolean updateAdmin(Admin admin);
    Admin getAdmin();
}
