package com.ExamChrono.controllers;

import com.ExamChrono.models.Entities.Admin;
import com.ExamChrono.services.interfaces.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@Controller
@CrossOrigin("*")
@RequestMapping("api/Admin")

public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/get")
    public Admin getAdmin() { return this.adminService.getAdmin();}
    @PostMapping("/login")
    public boolean loginAdmin(@RequestBody Admin admin) {
        return this.adminService.loginAdmin(admin);
    }
    @PutMapping("/update")
    public boolean updateAdmin(@RequestBody Admin admin) {
        return this.adminService.updateAdmin(admin);
    }
}
