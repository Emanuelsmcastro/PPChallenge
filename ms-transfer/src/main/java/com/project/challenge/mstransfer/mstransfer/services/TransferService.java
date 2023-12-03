package com.project.challenge.mstransfer.mstransfer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.challenge.mstransfer.mstransfer.DTOs.user.transfer.v1.TransferDTO;
import com.project.challenge.mstransfer.mstransfer.clients.CommonUserClient;
import com.project.challenge.mstransfer.mstransfer.entities.Transfer;
import com.project.challenge.mstransfer.mstransfer.infra.exceptions.TransferNotFound;
import com.project.challenge.mstransfer.mstransfer.mappers.v1.MapperTransfer;
import com.project.challenge.mstransfer.mstransfer.repositories.TransferRepository;

@Service
public class TransferService {

    @Autowired
    private TransferRepository rep;

    @Autowired
    private CommonUserClient commonUserClient;

    public TransferDTO findByUuid(String uuid) {
        return MapperTransfer
                .getInstance()
                .toDTO(getEntityByUuid(uuid));
    }

    private Transfer getEntityByUuid(String uuid) {
        return rep
                .findByUuid(uuid)
                .orElseThrow(() -> new TransferNotFound(
                        String.format("Transfer (%s) not found.", uuid)));
    }
}
