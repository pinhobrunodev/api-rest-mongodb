package com.pinhobrunodev.workshopmongo.controllers.exceptions;

import com.pinhobrunodev.workshopmongo.services.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {

        HttpStatus status = HttpStatus.NOT_FOUND;

        StandardError error = new StandardError();
        error.setError("Not found");
        error.setMessage(e.getMessage());
        error.setPath(request.getRequestURI());
        error.setStatus(status.value());
        error.setTimestamp(Instant.now());

        return ResponseEntity.status(status).body(error);
    }
}
