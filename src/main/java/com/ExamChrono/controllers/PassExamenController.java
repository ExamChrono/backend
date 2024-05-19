package com.ExamChrono.controllers;

import com.ExamChrono.models.Dtos.PassExamenDto.PassExamenDto;
import com.ExamChrono.models.Entities.PassExamen;
import com.ExamChrono.services.interfaces.PassExamenService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Controller
@CrossOrigin("*")
@RequestMapping("api/PassExamen")

public class PassExamenController {
    private final PassExamenService passExamenService;

    public PassExamenController(PassExamenService passExamenService) {
        this.passExamenService = passExamenService;
    }

    @GetMapping("/all")
    public List<PassExamenDto> getAllPass () {
        return passExamenService.getAllPassExamenEtudiants();
    }

    @PostMapping("/add")
    public boolean addPass (@RequestBody PassExamen passExamen) {
        return passExamenService.addPassExamen(passExamen);
    }

    @PutMapping("/update")
    public boolean updatePass (@RequestBody PassExamen passExamen) {
        return passExamenService.updatePassExamen(passExamen);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deletePass (@PathVariable Long id) {
        return passExamenService.deletePassExamen(id);
    }
}
