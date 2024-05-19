package com.ExamChrono.controllers;

import com.ExamChrono.models.Dtos.SurveilleDto.SurveilleDto;
import com.ExamChrono.models.Entities.Surveille;
import com.ExamChrono.services.interfaces.SurveilleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Controller
@CrossOrigin("*")
@RequestMapping("api/Surveille")

public class SurveilleController {
    private final SurveilleService surveilleService;

    public SurveilleController(SurveilleService surveilleService) {
        this.surveilleService = surveilleService;
    }

    @GetMapping("/all")
    public List<SurveilleDto> getAllSurveille() {
        return surveilleService.getAllSurveille();
    }

    @GetMapping("/getAllSurveilleByIdEnseignant/{idEnseignant}")
    public List<SurveilleDto> getAllSurveilleByIdEnseignant(@PathVariable Long idEnseignant) {
        return surveilleService.getAllSurveilleByIdEnseignant(idEnseignant);
    }

    @PostMapping("/add")
    public boolean addSurveille(@RequestBody Surveille surveille) {
        return surveilleService.addSurveille(surveille);
    }

    @PutMapping("/update")
    public boolean updateSurveille(@RequestBody Surveille surveille) {
        return surveilleService.updateSurveille(surveille);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteSurveille(@PathVariable Long id) {
        return surveilleService.deleteSurveille(id);
    }
}
