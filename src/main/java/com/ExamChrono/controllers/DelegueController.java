package com.ExamChrono.controllers;

import com.ExamChrono.models.Dtos.DelegueDto.DelegueDto;
import com.ExamChrono.models.Dtos.EtudiantDto.EtudiantDto;
import com.ExamChrono.models.Entities.Delegue;
import com.ExamChrono.models.Entities.Etudiant;
import com.ExamChrono.services.interfaces.DelegueService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Controller
@CrossOrigin("*")
@RequestMapping("api/Delegue")

public class DelegueController {
    private final DelegueService delegueService;

    public DelegueController(DelegueService delegueService) {
        this.delegueService = delegueService;
    }
    @GetMapping("/all")
    public List<DelegueDto> getAllDelegues() {
        return delegueService.getAllDelegues();
    }
    @PostMapping("/login")
    public EtudiantDto loginDelegue(@RequestBody Etudiant etudiant) {
        return delegueService.loginDelegue(etudiant);
    }
    @PostMapping("/getByEmail")
    public EtudiantDto getDelegueByEmail(@RequestBody Delegue delegue) {
        return delegueService.getDelegueByEmail(delegue);
    }
    @PostMapping("/create")
    public boolean createDelegue(@RequestBody Delegue delegue) {
        return delegueService.createDelegue(delegue);
    }
    @DeleteMapping("/delete")
    public boolean deleteDelegue(@RequestBody Delegue delegue) {
        return delegueService.deleteDelegue(delegue);
    }
}
