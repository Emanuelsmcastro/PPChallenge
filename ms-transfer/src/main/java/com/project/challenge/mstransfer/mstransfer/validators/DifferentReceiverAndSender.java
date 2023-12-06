package com.project.challenge.mstransfer.mstransfer.validators;

import com.project.challenge.mstransfer.mstransfer.DTOs.user.v1.UserDTO;
import com.project.challenge.mstransfer.mstransfer.clients.UserClient;
import com.project.challenge.mstransfer.mstransfer.entities.Transfer;
import com.project.challenge.mstransfer.mstransfer.enumerations.TransferStatus;
import com.project.challenge.mstransfer.mstransfer.interfaces.IValidator;

public class DifferentReceiverAndSender implements IValidator<Transfer> {

    private UserClient userClient;

    public DifferentReceiverAndSender(UserClient userClient) {
        this.userClient = userClient;
    }

    public UserClient getUserClient() {
        return userClient;
    }

    @Override
    public void execute(Transfer obj) {
        UserDTO sender = userClient.getUserByCommonUserUuid(obj.getUuidSender()).getBody();
        UserDTO receiver = userClient.getUserByShopKeeperOrCommonUserUuid(obj.getUuidReceiver()).getBody();
        System.out.println(sender);
        System.out.println(receiver);
        if (sender.getUuid().equals(receiver.getUuid())) {
            obj.setStatus(TransferStatus.FAIL);
        }
    }

}
