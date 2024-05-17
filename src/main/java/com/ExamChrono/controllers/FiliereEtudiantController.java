package com.ExamChrono.controllers;

import com.ExamChrono.models.Dtos.FiliereEtudiantDto.FiliereEtudiantDto;
import com.ExamChrono.models.Dtos.FiliereWithStudentsDto.FiliereWithStudentsDto;
import com.ExamChrono.services.interfaces.FiliereEtudiantService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Controller
@CrossOrigin("*")
@RequestMapping("api/FiliereEtudiant")

public class FiliereEtudiantController {
   private final FiliereEtudiantService filiereEtudiantService;

    public FiliereEtudiantController(FiliereEtudiantService filiereEtudiantService) {
        this.filiereEtudiantService = filiereEtudiantService;
    }

    @GetMapping("/all")
    public List<FiliereWithStudentsDto> getAllFiliereEtudiant() {
        return filiereEtudiantService.getAllFiliereEtudiant();
    }

    @PostMapping("/add")
    public boolean addEtudiantToFiliere(@RequestBody FiliereEtudiantDto filiereEtudiantDto) {
        return filiereEtudiantService.addEtudiantToFiliere(filiereEtudiantDto);
    }
    @DeleteMapping("/delete/{filiereId}/{etudiantId}")
    public boolean deleteEtudiantFromFiliere(@PathVariable Long filiereId, @PathVariable Long etudiantId) {
        return filiereEtudiantService.deleteEtudiantFromFiliere(filiereId,etudiantId);
    }
}
