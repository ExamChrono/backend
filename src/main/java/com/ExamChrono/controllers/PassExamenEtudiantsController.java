package com.ExamChrono.controllers;

import com.ExamChrono.models.Dtos.PassExamenEtudiantsDto.PassExamenEtudiantsDto;
import com.ExamChrono.models.Entities.PassExamenEtudiant;
import com.ExamChrono.services.interfaces.PassExamenEtudiantsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Controller
@CrossOrigin("*")
@RequestMapping("api/PassExamenEtudiants")

public class PassExamenEtudiantsController {
    private final PassExamenEtudiantsService passExamenEtudiantsService;

    public PassExamenEtudiantsController(PassExamenEtudiantsService passExamenEtudiantsService) {
        this.passExamenEtudiantsService = passExamenEtudiantsService;
    }

    @GetMapping("/all")
    public List<PassExamenEtudiantsDto> getAllPassEsamenEtudiants() {
        return this.passExamenEtudiantsService.getAllPassEsamenEtudiants();
    }

    @PostMapping("/add")
    public boolean addPassEsamenEtudiant(@RequestBody List<PassExamenEtudiant> passExamenEtudiant) {
        return this.passExamenEtudiantsService.addEtudiantToPassEsamen(passExamenEtudiant);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deletePassEsamenEtudiant(@PathVariable Long id) {
        return this.passExamenEtudiantsService.deleteEtudiantFromPassEsamen(id);
    }
}
