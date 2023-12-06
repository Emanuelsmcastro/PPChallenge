package com.project.challenge.mstransfer.mstransfer.validators;

import com.project.challenge.mstransfer.mstransfer.DTOs.user.v1.UserDTO;
import com.project.challenge.mstransfer.mstransfer.clients.UserClient;
import com.project.challenge.mstransfer.mstransfer.entities.Transfer;
import com.project.challenge.mstransfer.mstransfer.enumerations.TransferStatus;
import com.project.challenge.mstransfer.mstransfer.interfaces.IValidator;

public class InsufficientFunds implements IValidator<Transfer> {

    private UserClient userClient;

    public InsufficientFunds(UserClient userClient) {
        this.userClient = userClient;
    }

    public UserClient getUserClient() {
        return userClient;
    }

    @Override
    public void execute(Transfer obj) {
        UserDTO commonUserDTO = userClient.getUserByCommonUserUuid(obj.getUuidSender()).getBody();

        if (obj.getValueToReceive() > commonUserDTO.getBalance()) {
            obj.setStatus(TransferStatus.FAIL);
        }
    }

}
