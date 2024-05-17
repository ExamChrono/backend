package com.ExamChrono.controllers;

import com.ExamChrono.models.Dtos.FiliereWithGroupesDto.FiliereWithGroupesDto;
import com.ExamChrono.models.Dtos.GroupeDto.Groupe2Dto;
import com.ExamChrono.models.Dtos.GroupeDto.GroupeDto;
import com.ExamChrono.services.interfaces.GroupeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Controller
@CrossOrigin("*")
@RequestMapping("api/Groupe")

public class GroupeController {
    private final GroupeService groupeService;

    public GroupeController(GroupeService groupeService) {
        this.groupeService = groupeService;
    }

    @GetMapping("/all")
    public List<FiliereWithGroupesDto> getAllGroupes() {
        return groupeService.getAllGroupes();
    }

    @PostMapping("/add")
    public boolean createGroupe(@RequestBody GroupeDto groupeDto) {
        return groupeService.addGroupe(groupeDto);
    }

    @PutMapping("/update")
    public boolean updateGroupe(@RequestBody Groupe2Dto groupeDto) {
        return groupeService.updateGroupe(groupeDto);
    }

    @DeleteMapping("/delete/{filiereId}/{groupeId}")
    public boolean deleteGroupe(@PathVariable Long filiereId, @PathVariable Long groupeId) {
        return groupeService.deleteGroupe(filiereId, groupeId);
    }
}
