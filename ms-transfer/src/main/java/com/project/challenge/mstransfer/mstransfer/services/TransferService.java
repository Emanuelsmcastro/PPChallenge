package com.project.challenge.mstransfer.mstransfer.services;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.project.challenge.mstransfer.mstransfer.DTOs.transfer.v1.TransferDTO;
import com.project.challenge.mstransfer.mstransfer.DTOs.transfer.v1.TransferRequestDTO;
import com.project.challenge.mstransfer.mstransfer.DTOs.user.v1.UserBalanceDTO;
import com.project.challenge.mstransfer.mstransfer.DTOs.user.v1.UserDTO;
import com.project.challenge.mstransfer.mstransfer.clients.MockClient;
import com.project.challenge.mstransfer.mstransfer.clients.UserClient;
import com.project.challenge.mstransfer.mstransfer.entities.Checkout;
import com.project.challenge.mstransfer.mstransfer.entities.Transfer;
import com.project.challenge.mstransfer.mstransfer.enumerations.TransferStatus;
import com.project.challenge.mstransfer.mstransfer.factories.TransferFactory;
import com.project.challenge.mstransfer.mstransfer.infra.exceptions.TransferNotFound;
import com.project.challenge.mstransfer.mstransfer.mappers.v1.MapperTransfer;
import com.project.challenge.mstransfer.mstransfer.repositories.TransferRepository;
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
                .toDTO(getEntityByUuid(uuid));
    }

    public TransferDTO createTransfer(TransferRequestDTO transferRequestDTO) {
        transferRequestValidation(transferRequestDTO);
        Transfer transfer = generateTransferByTransferRequest(transferRequestDTO);
        Map<String, ?> differentReceiverAndSenderResult = transactionValidationWithReturnedValue(transfer)
                .get("DifferentReceiverAndSenderValidator");
        if (!ObjectUtils.isEmpty(differentReceiverAndSenderResult)) {
            transactionValidationWithoutReturnedValue(differentReceiverAndSenderResult, transfer);
            executeTransaction(differentReceiverAndSenderResult, transfer);
        }
        saveTransfer(transfer);
        return MapperTransfer
                .getInstance()
                .toDTO(transfer);
    }

    private void executeTransaction(Map<String, ?> senderReceiver, Transfer transfer) {
        Double value = transfer.getValueToReceive();
        UserDTO sender = (UserDTO) senderReceiver.get("sender");
        UserDTO receiver = (UserDTO) senderReceiver.get("receiver");
        Checkout checkout = new Checkout(value, receiver, sender);
        checkoutValidation(checkout);
        UserBalanceDTO senderBalance = new UserBalanceDTO(
                sender.getUuid(),
                sender.getBalance() - value);
        UserBalanceDTO receiverBalance = new UserBalanceDTO(
                receiver.getUuid(),
                receiver.getBalance() + value);
        System.out.println(receiverBalance);
        try {
            userClient.updateBalance(receiverBalance);
            userClient.updateBalance(senderBalance);
            transfer.setStatus(TransferStatus.SUCCESS);
        } catch (Exception e) {
            transfer.setStatus(TransferStatus.FAIL);
        }
    }

    private void checkoutValidation(Checkout checkout) {
        ValidatorManager<Checkout> checkManager = new ValidatorManager<>(
                new AboveTransferLimitValidator());
        checkManager.executeAll(checkout);
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
