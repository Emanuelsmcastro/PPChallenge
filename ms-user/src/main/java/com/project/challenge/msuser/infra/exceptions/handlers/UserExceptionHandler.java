package com.project.challenge.msuser.infra.exceptions.handlers;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.project.challenge.msuser.infra.exceptions.RoleTypeNotFound;
import com.project.challenge.msuser.infra.exceptions.UserTypeNotFound;
import com.project.challenge.msuser.infra.exceptions.DTOs.BasicResponseExceptionDTO;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler(UserTypeNotFound.class)
    public ResponseEntity<BasicResponseExceptionDTO> userTypeNotFound(UserTypeNotFound e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        BasicResponseExceptionDTO response = new BasicResponseExceptionDTO(status.name(), e.getMessage(),
                Instant.now().toString());
        return ResponseEntity.status(status).body(response);
    }

    @ExceptionHandler(RoleTypeNotFound.class)
    public ResponseEntity<BasicResponseExceptionDTO> roleTypeNotFound(RoleTypeNotFound e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        BasicResponseExceptionDTO response = new BasicResponseExceptionDTO(status.name(), e.getMessage(),
                Instant.now().toString());
        return ResponseEntity.status(status).body(response);
    }
}
