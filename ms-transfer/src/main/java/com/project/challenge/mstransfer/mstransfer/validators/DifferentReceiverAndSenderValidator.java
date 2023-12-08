package com.project.challenge.mstransfer.mstransfer.validators;

import java.util.Map;

import com.project.challenge.mstransfer.mstransfer.DTOs.user.v1.UserDTO;
import com.project.challenge.mstransfer.mstransfer.clients.UserClient;
import com.project.challenge.mstransfer.mstransfer.entities.Transfer;
import com.project.challenge.mstransfer.mstransfer.enumerations.TransferStatus;
import com.project.challenge.mstransfer.mstransfer.interfaces.IValidatorWithReturn;

public class DifferentReceiverAndSenderValidator implements IValidatorWithReturn<Transfer> {

    private UserClient userClient;

    public DifferentReceiverAndSenderValidator(UserClient userClient) {
        this.userClient = userClient;
    }

    public UserClient getUserClient() {
        return userClient;
    }

    @Override
    public void execute(Transfer obj) {
    }

    @Override
    public Map<String, ?> executeValidationWithReturn(Transfer obj) {
        UserDTO sender = userClient.getUserByCommonUserUuid(obj.getUuidSender()).getBody();
        UserDTO receiver = userClient.getUserByShopKeeperOrCommonUserUuid(obj.getUuidReceiver()).getBody();
        if (sender.getUuid().equals(receiver.getUuid())) {
            obj.setStatus(TransferStatus.FAIL);
            return null;
        }
        return Map.of("sender", sender, "receiver", receiver);

    }

}
