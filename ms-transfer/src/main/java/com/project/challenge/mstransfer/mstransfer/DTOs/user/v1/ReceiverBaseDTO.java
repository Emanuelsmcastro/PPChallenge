package com.project.challenge.mstransfer.mstransfer.DTOs.user.v1;

import com.project.challenge.mstransfer.mstransfer.interfaces.IReceiving;

public class ReceiverBaseDTO extends BaseUser implements IReceiving {

    public ReceiverBaseDTO() {

    }

    public ReceiverBaseDTO(String uuid) {
        super(uuid);
    }

    @Override
    public void toReceive(Double value) {
        System.out.println("Receive: " + value);
    }

}
