package com.project.challenge.mstransfer.mstransfer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.challenge.mstransfer.mstransfer.DTOs.transfer.v1.TransferDTO;
import com.project.challenge.mstransfer.mstransfer.DTOs.transfer.v1.TransferRequestDTO;
import com.project.challenge.mstransfer.mstransfer.DTOs.user.v1.ReceiverBaseDTO;
import com.project.challenge.mstransfer.mstransfer.clients.UserClient;
import com.project.challenge.mstransfer.mstransfer.entities.Transfer;
import com.project.challenge.mstransfer.mstransfer.enumerations.TransferStatus;
import com.project.challenge.mstransfer.mstransfer.factories.TransferFactory;
import com.project.challenge.mstransfer.mstransfer.infra.exceptions.TransferNotFound;
import com.project.challenge.mstransfer.mstransfer.mappers.v1.MapperTransfer;
import com.project.challenge.mstransfer.mstransfer.repositories.TransferRepository;
import com.project.challenge.mstransfer.mstransfer.validators.DifferentReceiverAndSender;
import com.project.challenge.mstransfer.mstransfer.validators.ReceiverValidator;
import com.project.challenge.mstransfer.mstransfer.validators.TransferValueValidator;
import com.project.challenge.mstransfer.mstransfer.validators.ValidatorManager;

@Service
public class TransferService {

    @Autowired
    private TransferRepository rep;

    @Autowired
    private UserClient userClient;

    public TransferDTO findByUuid(String uuid) {
        return MapperTransfer
                .getInstance()
                .toDTO(getEntityByUuid(uuid));
    }

    public TransferDTO createTransfer(TransferRequestDTO transferRequestDTO) {
        transferRequestValidation(transferRequestDTO);
        Transfer transfer = generateTransferByTransferRequest(transferRequestDTO);
        transactionValidation(transfer);
        saveTransfer(transfer);
        return MapperTransfer
                .getInstance()
                .toDTO(transfer);
    }

    private void transactionValidation(Transfer transfer) {
        ValidatorManager<Transfer> transferManager = new ValidatorManager<>(
                new DifferentReceiverAndSender(userClient));
        transferManager.executeAll(transfer);
    }

    private void transferRequestValidation(TransferRequestDTO transfer) {
        ValidatorManager<TransferRequestDTO> validatorManager = new ValidatorManager<>(
                new ReceiverValidator(userClient),
                new TransferValueValidator());
        validatorManager.executeAll(transfer);
    }

    private ReceiverBaseDTO getReceiverBase(String uuid) {
        return new ReceiverBaseDTO(uuid);
    }

    private Transfer getEntityByUuid(String uuid) {
        return rep
                .findByUuid(uuid)
                .orElseThrow(() -> new TransferNotFound(
                        String.format("Transfer (%s) not found.", uuid)));
    }

    private void saveTransfer(Transfer transfer) {
        rep.save(transfer);
    }

    private Transfer generateTransferByTransferRequest(TransferRequestDTO transferRequestDTO) {
        TransferStatus status = TransferStatus.PENDING;
        return TransferFactory
                .getInstance()
                .autoUuid()
                .setValueToReceive(transferRequestDTO.getValueToReceive())
                .setReceiver(getReceiverBase(transferRequestDTO.getReceiver().getUuid()))
                .setSender(transferRequestDTO.getSender())
                .setStatus(status)
                .setNow()
                .build();
    }
}
