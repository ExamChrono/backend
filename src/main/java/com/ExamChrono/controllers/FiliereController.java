package com.ExamChrono.controllers;

import com.ExamChrono.models.Dtos.FiliereDto.FiliereDto;
import com.ExamChrono.models.Entities.Filiere;
import com.ExamChrono.services.interfaces.FiliereService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Controller
@CrossOrigin("*")
@RequestMapping("api/Filiere")

public class FiliereController {
    private final FiliereService filiereService;

    public FiliereController(FiliereService filiereService) {
        this.filiereService = filiereService;
    }

    @GetMapping("/all")
    public List<FiliereDto>  getAllFilieres() {
        return filiereService.getAllFilieres();
    }

    @PostMapping("/add")
    public boolean createFiliere(@RequestBody Filiere filiere) {
        return filiereService.createFiliere(filiere);
    }

    @PutMapping("/update")
    public boolean updateFiliere(@RequestBody Filiere filiere) {
        return filiereService.updateFiliere(filiere);
    }

    @DeleteMapping("/delete")
    public boolean deleteFiliere(@RequestBody Filiere filiere) {
        return filiereService.deleteFiliere(filiere);
    }
}
