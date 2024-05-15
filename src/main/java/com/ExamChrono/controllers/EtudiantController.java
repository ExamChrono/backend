package com.ExamChrono.controllers;

import com.ExamChrono.models.Dtos.EtudiantDto.EtudiantDto;
import com.ExamChrono.models.Entities.Etudiant;
import com.ExamChrono.services.interfaces.EtudiantService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Controller
@CrossOrigin("*")
@RequestMapping("api/Etudiant")

public class EtudiantController {
   private final EtudiantService etudiantService;

    public EtudiantController(EtudiantService etudiantService) {
        this.etudiantService = etudiantService;
    }

    @GetMapping("/all")
    public List<EtudiantDto> getAllEtudiants() {
        return etudiantService.getAllEtudiants();
    }
    @PostMapping("/login")
    public EtudiantDto loginEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantService.loginEtudiant(etudiant);
    }
    @PutMapping("/update")
    public boolean updateEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantService.updateEtudiant(etudiant);
    }
    @PostMapping("/create/{validation}")
    public boolean createEtudiant(@RequestBody Etudiant etudiant, @PathVariable boolean validation) {
        return etudiantService.createEtudiant(etudiant, validation);
    }
    @DeleteMapping("/delete")
    public boolean deleteEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantService.deleteEtudiant(etudiant);
    }
    @PostMapping("/getByEmail")
    public EtudiantDto getEtudiantByEmail(@RequestBody Etudiant etudiant) {
        return etudiantService.getEtudiantByEmail(etudiant);
    }
}
