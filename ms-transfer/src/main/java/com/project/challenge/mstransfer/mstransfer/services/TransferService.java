package com.project.challenge.mstransfer.mstransfer.services;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.project.challenge.mstransfer.mstransfer.DTOs.transfer.v1.TransferDTO;
import com.project.challenge.mstransfer.mstransfer.DTOs.transfer.v1.TransferRequestDTO;
import com.project.challenge.mstransfer.mstransfer.DTOs.transfer.v2.TransferDTOWithHateoas;
import com.project.challenge.mstransfer.mstransfer.DTOs.user.v1.UserDTO;
import com.project.challenge.mstransfer.mstransfer.clients.MockClient;
import com.project.challenge.mstransfer.mstransfer.clients.UserClient;
import com.project.challenge.mstransfer.mstransfer.entities.Checkout;
import com.project.challenge.mstransfer.mstransfer.entities.Receiver;
import com.project.challenge.mstransfer.mstransfer.entities.Sender;
import com.project.challenge.mstransfer.mstransfer.entities.Transfer;
import com.project.challenge.mstransfer.mstransfer.enumerations.TransferStatus;
import com.project.challenge.mstransfer.mstransfer.factories.TransferFactory;
import com.project.challenge.mstransfer.mstransfer.infra.exceptions.TransferNotFound;
import com.project.challenge.mstransfer.mstransfer.mappers.v1.MapperTransfer;
import com.project.challenge.mstransfer.mstransfer.mappers.v1.MapperUserDTOReceiver;
import com.project.challenge.mstransfer.mstransfer.mappers.v1.MapperUserDTOSender;
import com.project.challenge.mstransfer.mstransfer.mappers.v2.MapperTransferWithHateoas;
import com.project.challenge.mstransfer.mstransfer.repositories.TransferRepository;
import com.project.challenge.mstransfer.mstransfer.resources.TransferResource;
import com.project.challenge.mstransfer.mstransfer.validators.AboveTransferLimitValidator;
import com.project.challenge.mstransfer.mstransfer.validators.DifferentReceiverAndSenderValidator;
import com.project.challenge.mstransfer.mstransfer.validators.InsufficientFundsValidator;
import com.project.challenge.mstransfer.mstransfer.validators.MockAuthValidator;
import com.project.challenge.mstransfer.mstransfer.validators.TransferValueValidator;
import com.project.challenge.mstransfer.mstransfer.validators.ValidatorManager;

@Service
public class TransferService {

    @Autowired
    private TransferRepository rep;

    @Autowired
    private UserClient userClient;

    @Autowired
    private MockClient mockClient;

    public TransferDTO findByUuid(String uuid) {
        return MapperTransfer
                .getInstance()
                .convert(getEntityByUuid(uuid));
    }

    public TransferDTOWithHateoas createTransfer(TransferRequestDTO transferRequestDTO) {
        transferRequestValidation(transferRequestDTO);
        Transfer transfer = generateTransferByTransferRequest(transferRequestDTO);
        Map<String, ?> differentReceiverAndSenderResult = transactionValidationWithReturnedValue(transfer)
                .get("DifferentReceiverAndSenderValidator");
        if (!ObjectUtils.isEmpty(differentReceiverAndSenderResult)) {
            transactionValidationWithoutReturnedValue(differentReceiverAndSenderResult, transfer);
            executeTransaction(differentReceiverAndSenderResult, transfer);
        }
        saveTransfer(transfer);
        
        TransferDTOWithHateoas result = MapperTransferWithHateoas
                .getInstance()
                .convert(transfer);
        result.add(linkTo(methodOn(TransferResource.class).findByUuid(result.getUuid())).withSelfRel());
        return result;
    }

    private void executeTransaction(Map<String, ?> senderReceiver, Transfer transfer) {
        Sender sender = MapperUserDTOSender
                .getInstance()
                .convert((UserDTO) senderReceiver.get("sender"));
        Receiver receiver = MapperUserDTOReceiver
                .getInstance()
                .convert((UserDTO) senderReceiver.get("receiver"));
        Checkout checkout = new Checkout(transfer.getValueToReceive(), receiver, sender);
        checkoutValidation(checkout);
        sender.toSend(receiver, checkout.getTransferValue());
        try {
            userClient.updateBalance(receiver.getUserBalanceDTO());
            userClient.updateBalance(sender.getUserBalanceDTO());
            transfer.setStatus(TransferStatus.SUCCESS);
        } catch (Exception e) {
            transfer.setStatus(TransferStatus.FAIL);
        }
    }

    private void checkoutValidation(Checkout sender) {
        ValidatorManager<Checkout> checkoutManager = new ValidatorManager<>(
                new AboveTransferLimitValidator());
        checkoutManager.executeAll(sender);
    }

    private void transactionValidationWithoutReturnedValue(Map<String, ?> senderReceiver, Transfer transfer) {
        ValidatorManager<Transfer> transferManager = new ValidatorManager<>(
                new InsufficientFundsValidator(senderReceiver),
                new MockAuthValidator(mockClient));
        transferManager.executeAll(transfer);
    }

    private Map<String, Map<String, ?>> transactionValidationWithReturnedValue(Transfer transfer) {
        ValidatorManager<Transfer> transferManager = new ValidatorManager<>();
        transferManager.addMapValidator(new DifferentReceiverAndSenderValidator(userClient));
        transferManager.executeMapValidation(transfer);
        return transferManager.getMapResults();
    }

    private void transferRequestValidation(TransferRequestDTO transfer) {
        ValidatorManager<TransferRequestDTO> validatorManager = new ValidatorManager<>(
                new TransferValueValidator());
        validatorManager.executeAll(transfer);
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
                .setReceiver(transferRequestDTO.getReceiver().getUuid())
                .setSender(transferRequestDTO.getSender())
                .setStatus(status)
                .setNow()
                .build();
    }
}
