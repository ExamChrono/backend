package com.ExamChrono.controllers;

import com.ExamChrono.models.Entities.Validation;
import com.ExamChrono.services.interfaces.ValidationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@Controller
@CrossOrigin("*")
@RequestMapping("api/Validation")

public class ValidationController {
    private final ValidationService validationService;

    public ValidationController(ValidationService validationService) {
        this.validationService = validationService;
    }

    @PostMapping("/sendCode/{subject}")
    public Long sendCode(@RequestBody Validation validation, @PathVariable String subject) {
        return validationService.sendCode(validation, subject);
    }

    @PostMapping("/validateCode")
    public Boolean validateCode(@RequestBody Validation validation) {
        return validationService.validateCode(validation);
    }
}
