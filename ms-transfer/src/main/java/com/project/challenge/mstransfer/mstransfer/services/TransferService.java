package com.project.challenge.mstransfer.mstransfer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.challenge.mstransfer.mstransfer.DTOs.transfer.v1.TransferDTO;
import com.project.challenge.mstransfer.mstransfer.DTOs.transfer.v1.TransferRequestDTO;
import com.project.challenge.mstransfer.mstransfer.DTOs.user.v1.ShopKeeperDTO;
import com.project.challenge.mstransfer.mstransfer.clients.CommonUserClient;
import com.project.challenge.mstransfer.mstransfer.clients.ShopKeeperClient;
import com.project.challenge.mstransfer.mstransfer.entities.Transfer;
import com.project.challenge.mstransfer.mstransfer.enumerations.TransferStatus;
import com.project.challenge.mstransfer.mstransfer.factories.TransferFactory;
import com.project.challenge.mstransfer.mstransfer.infra.exceptions.TransferNotFound;
import com.project.challenge.mstransfer.mstransfer.mappers.v1.MapperTransfer;
import com.project.challenge.mstransfer.mstransfer.repositories.TransferRepository;
import com.project.challenge.mstransfer.mstransfer.validators.ReceiverValidator;
import com.project.challenge.mstransfer.mstransfer.validators.TransferValueValidator;
import com.project.challenge.mstransfer.mstransfer.validators.ValidatorManager;

@Service
public class TransferService {

    @Autowired
    private TransferRepository rep;

    @Autowired
    private ShopKeeperClient shopKeeperClient;

    @Autowired
    private CommonUserClient commonUserClient;

    public TransferDTO findByUuid(String uuid) {
        return MapperTransfer
                .getInstance()
                .toDTO(getEntityByUuid(uuid));
    }

    public TransferDTO createTransfer(TransferRequestDTO transferRequestDTO) {
        TransferStatus status = TransferStatus.PENDING;
        // try {
        // transferRequestValidation(transferRequestDTO);
        // } catch (Exception e) {
        // status = TransferStatus.FAIL;
        // }
        Transfer transfer = TransferFactory
                .getInstance()
                .autoUuid()
                .setValueToReceive(transferRequestDTO.getValueToReceive())
                .setReceiver(findReceiver(transferRequestDTO.getShopKeeper().getUuid()))
                .setSender(transferRequestDTO.getSender())
                .setStatus(status)
                .setNow()
                .build();
        rep.save(transfer);
        return MapperTransfer
                .getInstance()
                .toDTO(transfer);
    }

    private void transferRequestValidation(TransferRequestDTO transfer) {
        ValidatorManager<TransferRequestDTO> validatorManager = new ValidatorManager<>(
                new ReceiverValidator(commonUserClient),
                new TransferValueValidator());
        validatorManager.executeAll(transfer);
    }

    private ShopKeeperDTO findReceiver(String uuid) {
        return shopKeeperClient.findByUuid(uuid).getBody();
    }

    private Transfer getEntityByUuid(String uuid) {
        return rep
                .findByUuid(uuid)
                .orElseThrow(() -> new TransferNotFound(
                        String.format("Transfer (%s) not found.", uuid)));
    }
}
