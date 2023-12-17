package com.project.challenge.mstransfer.mstransfer.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.challenge.mstransfer.mstransfer.DTOs.transfer.v1.TransferDTO;
import com.project.challenge.mstransfer.mstransfer.DTOs.transfer.v1.TransferRequestDTO;
import com.project.challenge.mstransfer.mstransfer.infra.exceptions.DTOs.BasicResponseExceptionDTO;
import com.project.challenge.mstransfer.mstransfer.services.TransferService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Transfer Resource V1", description = "These endpoints are responsible for handling all available functionalities related to the transfer.")
@RequestMapping(value = "/ppchallenge/v1/transfers")
public class TransferResource {

    @Autowired
    private TransferService service;

    @GetMapping(value = "/{uuid}")
    @Operation(summary = "Find transfer.", description = "Return transfer by uuid.", responses = {
    		@ApiResponse(description = "Success", responseCode = "200", content = {
    				@Content(mediaType = "application/json", schema = @Schema(implementation = TransferDTO.class))
    		}),
    		@ApiResponse(description = "Not found", responseCode = "404", content = {
    				@Content(mediaType = "application/json", schema = @Schema(implementation = BasicResponseExceptionDTO.class))
    		})
    })
    public ResponseEntity<TransferDTO> findByUuid(@PathVariable(value = "uuid") String uuid) {
        return ResponseEntity.ok().body(service.findByUuid(uuid));
    }

    @CrossOrigin(origins = "http://localhost:8765")
    @PostMapping
    @Operation(summary = "Transfer request.", description = "Returns a transfer after executing it.", responses = {
    		@ApiResponse(description = "Success", responseCode = "200", content = {
    				@Content(mediaType = "application/json", schema = @Schema(implementation = TransferDTO.class))
    		}),
    		@ApiResponse(description = "Fail", responseCode = "400", content = {
    				@Content(mediaType = "application/json", schema = @Schema(implementation = BasicResponseExceptionDTO.class))
    		})
    })
    public ResponseEntity<TransferDTO> createTransfer(@RequestBody TransferRequestDTO transfer) {
        HttpStatus status = HttpStatus.CREATED;
        return ResponseEntity.status(status.value()).body(service.createTransfer(transfer));
    }
}
