package com.project.challenge.mstransfer.mstransfer.validators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.project.challenge.mstransfer.mstransfer.DTOs.transfer.v1.TransferRequestDTO;
import com.project.challenge.mstransfer.mstransfer.clients.UserClient;
import com.project.challenge.mstransfer.mstransfer.interfaces.IValidator;

public class ReceiverValidator implements IValidator<TransferRequestDTO> {

    private UserClient userClient;

    private Logger log = LoggerFactory.getLogger(getClass());

    public ReceiverValidator() {

    }

    public ReceiverValidator(UserClient userClient) {
        this.userClient = userClient;
    }

    @Override
    public void execute(TransferRequestDTO transfer) {
        log.info("Check receiver uuid: " + transfer.getReceiver().getUuid());
        userClient.getUserByShopKeeperOrCommonUserUuid(transfer.getReceiver().getUuid());
    }

}
