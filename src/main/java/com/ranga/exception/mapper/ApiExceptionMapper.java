package com.ranga.exception.mapper;

import com.ranga.exception.BaseException;
import com.ranga.exception.ConstraintValidationException;
import com.ranga.exception.UnsupportedOperationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

/**
 * Created by RANGA on 2/1/2017.
 */
@ControllerAdvice
public class ApiExceptionMapper {

    // Catch All Exception
    @ExceptionHandler({
            Exception.class
    })
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public Fault internalError(Exception exception) {
        String code = HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase();
        String refId = UUID.randomUUID().toString();
        return new Fault(refId, exception.getMessage(), code);
    }

    @ExceptionHandler({
            BaseException.class,
            ConstraintValidationException.class
    })
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Fault clientException(BaseException exception) {
        String code = HttpStatus.BAD_REQUEST.getReasonPhrase();
        String refId = UUID.randomUUID().toString();
        return new Fault(refId, exception.getLocalizedMessage(), code);
    }

    @ExceptionHandler({
            UnsupportedOperationException.class
    })
    @ResponseStatus(value = HttpStatus.NOT_IMPLEMENTED)
    @ResponseBody
    public Fault notImplemented(BaseException exception) {
        String code = HttpStatus.NOT_IMPLEMENTED.getReasonPhrase();
        String refId = UUID.randomUUID().toString();
        return new Fault(refId, exception.getLocalizedMessage(), code);
    }
}
