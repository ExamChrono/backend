package com.ExamChrono.controllers;

import com.ExamChrono.models.Dtos.FiliereWithModulesDto.FiliereWithModulesDto;
import com.ExamChrono.models.Dtos.ModulesDto.ModulesDto;
import com.ExamChrono.services.interfaces.ModulesService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Controller
@CrossOrigin("*")
@RequestMapping("api/Modules")

public class ModulesController {
    private final ModulesService modulesService;

    public ModulesController(ModulesService modulesService) {
        this.modulesService = modulesService;
    }

    @GetMapping("/all")
    public List<FiliereWithModulesDto> getAllModules() {
        return modulesService.getAllModules();
    }

    @PostMapping("/add")
    public boolean createModule(@RequestBody ModulesDto modulesDto) {
        return modulesService.addModule(modulesDto);
    }

    @PutMapping("/update")
    public boolean updateModule(@RequestBody ModulesDto modulesDto) {
        return modulesService.updateModule(modulesDto);
    }

    @DeleteMapping("/delete/{filiereId}/{moduleId}")
    public boolean deleteModule(@PathVariable Long filiereId, @PathVariable Long moduleId) {
        return modulesService.deleteModule(filiereId, moduleId);
    }
    @GetMapping("/getModule/{idDelegue}")
    public FiliereWithModulesDto getModule(@PathVariable Long idDelegue) {
        return modulesService.getModule(idDelegue);
    }
}
