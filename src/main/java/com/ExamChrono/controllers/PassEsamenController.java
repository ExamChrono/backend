package com.ExamChrono.controllers;

import com.ExamChrono.models.Dtos.PassEsamenDto.PassEsamenDto;
import com.ExamChrono.models.Entities.PassEsamen;
import com.ExamChrono.services.interfaces.PassEsamenService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Controller
@CrossOrigin("*")
@RequestMapping("api/PassEsamen")

public class PassEsamenController {
    private final PassEsamenService passEsamenService;

    public PassEsamenController(PassEsamenService passEsamenService) {
        this.passEsamenService = passEsamenService;
    }

    @GetMapping("/all")
    public List<PassEsamenDto> getAllPass () {
        return passEsamenService.getAllPassEsamenEtudiants();
    }

    @PostMapping("/add")
    public boolean addPass (@RequestBody PassEsamen passEsamen) {
        return passEsamenService.addPassEsamen(passEsamen);
    }

    @PutMapping("/update")
    public boolean updatePass (@RequestBody PassEsamen passEsamen) {
        return passEsamenService.updatePassEsamen(passEsamen);
    }

    @DeleteMapping("/delete")
    public boolean deletePass (@RequestBody PassEsamen passEsamen) {
        return passEsamenService.deletePassEsamen(passEsamen);
    }
}
