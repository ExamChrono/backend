package com.ExamChrono.services;

import com.ExamChrono.models.Entities.Validation;
import com.ExamChrono.repositories.ValidationRepository;
import com.ExamChrono.services.interfaces.ValidationService;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class ValidationServiceImpl implements ValidationService {
    private final EmailService emailService;
    private final ValidationRepository validationRepository;

    public ValidationServiceImpl(EmailService emailService, ValidationRepository validationRepository) {
        this.emailService = emailService;
        this.validationRepository = validationRepository;
    }

    @Override
    public Long sendCode(Validation validation, String subject) {
        String email = validation.getEmail();
        long code = generateCode();
        subject = subject.replace("+"," ");
        this.emailService.sendEmail(email,
                subject,
                subject+"'s code is: " + code);
        validation.setCode(code);
        this.validationRepository.save(validation);
        return code;
    }

    @Override
    public Boolean validateCode(Validation validation) {
        return this.validationRepository.existsByCodeAndEmail(validation.getCode(), validation.getEmail());
    }

    public long generateCode() {
        return ThreadLocalRandom.current().nextLong(100000, 999999);
    }
}
