package com.project.challenge.mstransfer.mstransfer.validators;

import com.project.challenge.mstransfer.mstransfer.entities.Checkout;
import com.project.challenge.mstransfer.mstransfer.infra.exceptions.TransferValueException;
import com.project.challenge.mstransfer.mstransfer.interfaces.IValidator;

public class AboveTransferLimitValidator implements IValidator<Checkout> {

    public AboveTransferLimitValidator() {

    }

    @Override
    public void execute(Checkout checkout) {
        if (checkout.getSender().getCommonUser().getTransferLimit() < checkout.getTransferValue())
            throw new TransferValueException("Transfer above the sender's account limit.");
    }

}
