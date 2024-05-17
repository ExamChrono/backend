package com.ExamChrono.controllers;

import com.ExamChrono.models.Dtos.SalleDto.SalleDto;
import com.ExamChrono.models.Entities.Salle;
import com.ExamChrono.services.interfaces.SalleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Controller
@CrossOrigin("*")
@RequestMapping("api/Salle")

public class SalleController {
    private final SalleService salleService;

    public SalleController(SalleService salleService) {
        this.salleService = salleService;
    }

    @GetMapping("/all")
    public List<SalleDto> getAllSalles() {
        return salleService.getAllSalles();
    }

    @PostMapping("/add")
    public boolean addSalle(@RequestBody Salle salle) {
        return salleService.addSalle(salle);
    }

    @PutMapping("/update")
    public boolean updateSalle(@RequestBody Salle salle) {
        return salleService.updateSalle(salle);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteSalle(@PathVariable Long id) {
        return salleService.deleteSalle(id);
    }
}
