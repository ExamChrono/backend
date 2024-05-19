package com.ExamChrono.controllers;

import com.ExamChrono.models.Dtos.EtudiantDto.EtudiantDto;
import com.ExamChrono.models.Dtos.PassExamenDto.PassExamenDto;
import com.ExamChrono.models.Dtos.PassExamenEtudiantsDto.PassExamenEtudiantsDto;
import com.ExamChrono.models.Entities.PassExamenEtudiant;
import com.ExamChrono.services.interfaces.PassExamenEtudiantsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Controller
@CrossOrigin("*")
@RequestMapping("api/PassExamenEtudiant")

public class PassExamenEtudiantsController {
    private final PassExamenEtudiantsService passExamenEtudiantsService;

    public PassExamenEtudiantsController(PassExamenEtudiantsService passExamenEtudiantsService) {
        this.passExamenEtudiantsService = passExamenEtudiantsService;
    }

    @GetMapping("/all")
    public List<PassExamenEtudiantsDto> getAllPassExamenEtudiants() {
        return this.passExamenEtudiantsService.getAllPassExamenEtudiants();
    }

    @PostMapping("/add")
    public boolean addPassExamenEtudiant(@RequestBody List<PassExamenEtudiant> passExamenEtudiant) {
        return this.passExamenEtudiantsService.addEtudiantToPassExamen(passExamenEtudiant);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deletePassExamenEtudiant(@PathVariable Long id) {
        return this.passExamenEtudiantsService.deleteEtudiantFromPassExamen(id);
    }

    @PostMapping("/getEtudiantToPassExamen")
    public List<EtudiantDto> getEtudiantToPassExamen(@RequestBody PassExamenDto passExamen) {
        return this.passExamenEtudiantsService.getEtudiantToPassExamen(passExamen);
    }

}
