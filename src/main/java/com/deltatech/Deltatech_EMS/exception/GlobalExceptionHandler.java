package com.deltatech.Deltatech_EMS.exception;

import com.deltatech.Deltatech_EMS.model.ValidErrorResponse;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List<ValidErrorResponse>>handleMethodArgumentNotValidException
            (ConstraintViolationException ex){
        System.out.println("Inside Exception.");
        List<ValidErrorResponse>validErrorResponseList= new ArrayList<>();
        ex.getConstraintViolations().forEach(fieldError->{
            validErrorResponseList.add(new ValidErrorResponse(fieldError.getPropertyPath().toString(), fieldError.getMessage()));
        });
        return ResponseEntity.badRequest().body(validErrorResponseList);
    }
}

