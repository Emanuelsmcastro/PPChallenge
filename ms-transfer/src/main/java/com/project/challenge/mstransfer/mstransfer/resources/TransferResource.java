package com.project.challenge.mstransfer.mstransfer.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.challenge.mstransfer.mstransfer.DTOs.user.transfer.v1.TransferDTO;
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
}
