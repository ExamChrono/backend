package com.ExamChrono.controllers;

import com.ExamChrono.models.Dtos.PassEsamenEtudiantsDto.PassEsamenEtudiantsDto;
import com.ExamChrono.models.Entities.PassEsamenEtudiant;
import com.ExamChrono.services.interfaces.PassEsamenEtudiantsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Controller
@CrossOrigin("*")
@RequestMapping("api/PassEsamenEtudiant")

public class PassEsamenEtudiantsController {
    private final PassEsamenEtudiantsService passEsamenEtudiantsService;

    public PassEsamenEtudiantsController(PassEsamenEtudiantsService passEsamenEtudiantsService) {
        this.passEsamenEtudiantsService = passEsamenEtudiantsService;
    }

    @GetMapping("/all")
    public List<PassEsamenEtudiantsDto> getAllPassEsamenEtudiants() {
        return this.passEsamenEtudiantsService.getAllPassEsamenEtudiants();
    }

    @PostMapping("/add")
    public boolean addPassEsamenEtudiant(@RequestBody List<PassEsamenEtudiant> passEsamenEtudiant) {
        return this.passEsamenEtudiantsService.addEtudiantToPassEsamen(passEsamenEtudiant);
    }

    @DeleteMapping("/delete")
    public boolean deletePassEsamenEtudiant(@RequestBody PassEsamenEtudiant passEsamenEtudiant) {
        return this.passEsamenEtudiantsService.deleteEtudiantFromPassEsamen(passEsamenEtudiant);
    }
}
