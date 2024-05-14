package com.ExamChrono.services.interfaces;

import com.ExamChrono.models.Entities.Validation;

public interface ValidationService {
    Long sendCode(Validation validation, String subject);
    Boolean validateCode(Validation validation);
}
