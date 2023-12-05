package com.project.challenge.mstransfer.mstransfer.infra.exceptions.handlers;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.project.challenge.mstransfer.mstransfer.infra.exceptions.TransferNotFound;
import com.project.challenge.mstransfer.mstransfer.infra.exceptions.TransferValueException;
import com.project.challenge.mstransfer.mstransfer.infra.exceptions.DTOs.BasicResponseExceptionDTO;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class TransferHandler {

    @ExceptionHandler(TransferValueException.class)
    public ResponseEntity<BasicResponseExceptionDTO> transferValueException(TransferValueException e,
            HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        BasicResponseExceptionDTO response = new BasicResponseExceptionDTO(status.name(), e.getMessage(),
                Instant.now().toString());
        return ResponseEntity.status(status).body(response);
    }

    @ExceptionHandler(TransferNotFound.class)
    public ResponseEntity<BasicResponseExceptionDTO> transferNotFound(TransferNotFound e,
            HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        BasicResponseExceptionDTO response = new BasicResponseExceptionDTO(status.name(), e.getMessage(),
                Instant.now().toString());
        return ResponseEntity.status(status).body(response);
    }
}
