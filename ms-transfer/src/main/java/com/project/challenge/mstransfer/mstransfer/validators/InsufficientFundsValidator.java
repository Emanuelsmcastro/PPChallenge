package com.project.challenge.mstransfer.mstransfer.validators;

import java.util.Map;

import com.project.challenge.mstransfer.mstransfer.DTOs.user.v1.UserDTO;
import com.project.challenge.mstransfer.mstransfer.entities.Transfer;
import com.project.challenge.mstransfer.mstransfer.infra.exceptions.TransferValueException;
import com.project.challenge.mstransfer.mstransfer.interfaces.IValidator;

public class InsufficientFundsValidator implements IValidator<Transfer> {

    private Map<String, ?> sendReceiver;

    public InsufficientFundsValidator(Map<String, ?> sendReceiver) {
        this.sendReceiver = sendReceiver;
    }

    @Override
    public void execute(Transfer transfer) {
        Double value = transfer.getValueToReceive();
        UserDTO sender = (UserDTO) sendReceiver.get("sender");
        if (sender.getBalance() < value) {
            throw new TransferValueException("Insufficient funds.");
        }
    }

}
