package com.project.challenge.mstransfer.mstransfer.validators;

import com.project.challenge.mstransfer.mstransfer.DTOs.transfer.v1.TransferRequestDTO;
import com.project.challenge.mstransfer.mstransfer.infra.exceptions.TransferValueException;
import com.project.challenge.mstransfer.mstransfer.interfaces.IValidator;

public class TransferValueValidator implements IValidator<TransferRequestDTO> {

    public TransferValueValidator() {

    }

    @Override
    public void execute(TransferRequestDTO transfer) {
        Double transferValue = transfer.getValueToReceive();
        Double valueToSend = transfer.getSender().getValueToSend();
        if (transferValue.equals(valueToSend)) {
            return;
        }
        throw new TransferValueException(
                "Transfer value (%.2f) not equals value to send (%.2f).".formatted(transferValue, valueToSend));
    }

}
