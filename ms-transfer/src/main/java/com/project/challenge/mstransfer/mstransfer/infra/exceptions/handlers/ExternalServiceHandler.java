package com.project.challenge.mstransfer.mstransfer.infra.exceptions.handlers;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.project.challenge.mstransfer.mstransfer.infra.exceptions.ExternalServiceException;
import com.project.challenge.mstransfer.mstransfer.infra.exceptions.DTOs.BasicResponseExceptionDTO;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExternalServiceHandler {

    @ExceptionHandler(ExternalServiceException.class)
    public ResponseEntity<BasicResponseExceptionDTO> serviceUnavailable(ExternalServiceException e,
            HttpServletRequest request) {
        HttpStatus status = HttpStatus.UNAUTHORIZED;
        BasicResponseExceptionDTO response = new BasicResponseExceptionDTO(status.name(), e.getMessage(),
                Instant.now().toString());
        return ResponseEntity.status(status).body(response);
    }
}
