package com.project.challenge.mstransfer.mstransfer.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.challenge.mstransfer.mstransfer.DTOs.transfer.v1.TransferDTO;
import com.project.challenge.mstransfer.mstransfer.DTOs.transfer.v1.TransferRequestDTO;
import com.project.challenge.mstransfer.mstransfer.services.TransferService;

@RestController
@RequestMapping(value = "/ppchallenge/v1/transfers")
public class TransferResource {

    @Autowired
    private TransferService service;

    @GetMapping(value = "/{uuid}")
    public ResponseEntity<TransferDTO> findByUuid(@PathVariable(value = "uuid") String uuid) {
        return ResponseEntity.ok().body(service.findByUuid(uuid));
    }

    @PostMapping
    public ResponseEntity<TransferDTO> createTransfer(@RequestBody TransferRequestDTO transfer) {
        HttpStatus status = HttpStatus.CREATED;
        return ResponseEntity.status(status.value()).body(service.createTransfer(transfer));
    }
}
