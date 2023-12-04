package com.project.challenge.mstransfer.mstransfer.validators;

import com.project.challenge.mstransfer.mstransfer.DTOs.transfer.v1.TransferRequestDTO;
import com.project.challenge.mstransfer.mstransfer.clients.CommonUserClient;
import com.project.challenge.mstransfer.mstransfer.interfaces.IValidator;

public class ReceiverValidator implements IValidator<TransferRequestDTO> {

    private CommonUserClient commonUserClient;

    public ReceiverValidator() {

    }

    public ReceiverValidator(CommonUserClient commonUserClient) {
        this.commonUserClient = commonUserClient;
    }

    @Override
    public void execute(TransferRequestDTO transfer) {
        commonUserClient.findByUuid(transfer.getSender().getUuidSender());
    }

}
