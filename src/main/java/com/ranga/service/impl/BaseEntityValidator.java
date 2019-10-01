package com.ranga.service.impl;

import com.ranga.exception.ConstraintValidationException;
import com.ranga.service.operations.EntityValidator;

import javax.inject.Named;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by jabbars on 2/23/2017.
 */
@Named("BaseEntityValidator")
public class BaseEntityValidator<T> implements EntityValidator<T> {

    protected final Validator validator;

    public BaseEntityValidator(Validator validator) {
        this.validator = validator;
    }


    @Override
    public Set<ConstraintViolation<T>> validate(T model) {

        EntityValidator<T> validator = new BaseEntityValidator<>(Validation.buildDefaultValidatorFactory().getValidator());
        Set<ConstraintViolation<T>> messages = validator.validate(model);
        List<String> validationException = new ArrayList<>();
        if (!messages.isEmpty()) {
            for (ConstraintViolation<T> message : messages) {
                StringBuilder messageBuilder = new StringBuilder("");
                validationException.add(
                        messageBuilder.append("\n")
                                .append("Property : ").append(message.getPropertyPath().toString()).append(",   ")
                                .append("Message : ").append(message.getMessage()).append(",    ")
                                .append("Bean : ").append(message.getRootBean().getClass().getName()).toString());
            }
            throw new ConstraintValidationException(validationException.toString());
        }
        return messages;
    }
}