package com.project.challenge.mstransfer.mstransfer.infra.exceptions.handlers;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.challenge.mstransfer.mstransfer.infra.exceptions.DTOs.BasicResponseExceptionDTO;

import feign.FeignException;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class FeignHandler {

    @ExceptionHandler(FeignException.NotFound.class)
    public ResponseEntity<BasicResponseExceptionDTO> feignNotFound(FeignException.NotFound e,
            HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        BasicResponseExceptionDTO response = new BasicResponseExceptionDTO(status.name(), "Feign Client error.",
                Instant.now().toString());
        try {
            response = new ObjectMapper().readValue(e.contentUTF8(), BasicResponseExceptionDTO.class);
        } catch (JsonMappingException e1) {
            response = new BasicResponseExceptionDTO(status.name(), e1.getMessage(),
                    Instant.now().toString());
        } catch (JsonProcessingException e1) {
            response = new BasicResponseExceptionDTO(status.name(), e1.getMessage(),
                    Instant.now().toString());
        }

        return ResponseEntity.status(status).body(response);

    }

    @ExceptionHandler(FeignException.ServiceUnavailable.class)
    public ResponseEntity<BasicResponseExceptionDTO> serviceUnavailable(FeignException.ServiceUnavailable e,
            HttpServletRequest request) {
        HttpStatus status = HttpStatus.SERVICE_UNAVAILABLE;
        BasicResponseExceptionDTO response = new BasicResponseExceptionDTO(status.name(), "The service is unavailable.",
                Instant.now().toString());
        return ResponseEntity.status(status).body(response);
    }

    @ExceptionHandler(java.net.ConnectException.class)
    public ResponseEntity<BasicResponseExceptionDTO> connectionRefused(java.net.ConnectException e,
            HttpServletRequest request) {
        HttpStatus status = HttpStatus.SERVICE_UNAVAILABLE;
        BasicResponseExceptionDTO response = new BasicResponseExceptionDTO(status.name(), "The service is unavailable.",
                Instant.now().toString());
        return ResponseEntity.status(status).body(response);
    }
  
    @ExceptionHandler(FeignException.Unauthorized.class)
    public ResponseEntity<BasicResponseExceptionDTO> unautorized(feign.FeignException.Unauthorized e,
            HttpServletRequest request) {
        HttpStatus status = HttpStatus.UNAUTHORIZED;
        BasicResponseExceptionDTO response = new BasicResponseExceptionDTO(status.name(), e.getMessage(),
                Instant.now().toString());
        return ResponseEntity.status(status).body(response);
    }
}
