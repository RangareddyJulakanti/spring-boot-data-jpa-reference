package com.ranga.service.operations;

import javax.validation.ConstraintViolation;
import java.util.Set;

/**
 * This Class Validates User Input Json, which are Marked with
 *
 * @NotNull , @NotBlank etc., and Thorough a Detailed Message which are required
 * <p>
 * Created by jabbars on 2/23/2017.
 */
public interface EntityValidator<T> {

    Set<ConstraintViolation<T>> validate(T t);
}
