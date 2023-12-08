package com.project.challenge.mstransfer.mstransfer.DTOs.user.v1;

public class ReceiverDTO extends BaseUser {

    public ReceiverDTO() {

    }

    public ReceiverDTO(String uuid) {
        super(uuid);
    }

    @Override
    public String toString() {
        return "ReceiverDTO [" + "uuid = " + super.getUuid() + "]";
    }

}
