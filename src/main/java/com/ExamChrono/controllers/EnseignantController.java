package com.ExamChrono.controllers;

import com.ExamChrono.models.Dtos.EnseignantDto.EnseignantDto;
import com.ExamChrono.models.Entities.Enseignant;
import com.ExamChrono.services.interfaces.EnseignantService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Controller
@CrossOrigin("*")
@RequestMapping("api/Enseignant")

public class EnseignantController {
    private final EnseignantService enseignantService;

    public EnseignantController(EnseignantService enseignantService) {
        this.enseignantService = enseignantService;
    }

    @GetMapping("/all")
    public List<Enseignant> getAllEnseignants() {
        return enseignantService.getAllEnseignants();
    }
    @PostMapping("/login")
    public EnseignantDto loginEnseignant(@RequestBody Enseignant enseignant) {
        return enseignantService.loginEnseignant(enseignant);
    }
    @PutMapping("/update")
    public boolean updateEnseignant(@RequestBody Enseignant enseignant) {
        return enseignantService.updateEnseignant(enseignant);
    }
    @PostMapping("/create/{validation}")
    public boolean createEnseignant(@RequestBody Enseignant enseignant, @PathVariable boolean validation) {
        return enseignantService.createEnseignant(enseignant, validation);
    }
    @DeleteMapping("/delete/{id}")
    public boolean deleteEnseignant(@PathVariable Long id) {
        return enseignantService.deleteEnseignant(id);
    }
    @PostMapping("/getByEmail")
    public EnseignantDto getEnseignantByEmail(@RequestBody Enseignant enseignant) {
        return enseignantService.getEnseignantByEmail(enseignant);
    }
}
