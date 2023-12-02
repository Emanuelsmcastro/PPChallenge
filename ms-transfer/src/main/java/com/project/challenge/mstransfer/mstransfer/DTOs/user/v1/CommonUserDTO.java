package com.project.challenge.mstransfer.mstransfer.DTOs.user.v1;

import com.project.challenge.mstransfer.mstransfer.interfaces.ISendingReceiving;

public class CommonUserDTO extends BaseUser implements ISendingReceiving<BaseUser> {

    private Double transferLimit;

    public CommonUserDTO() {

    }

    public CommonUserDTO(String uuid, Double transferLimit) {
        super(uuid);
        this.transferLimit = transferLimit;
    }

    public Double getTransferLimit() {
        return transferLimit;
    }

    public void setTransferLimit(Double transferLimit) {
        this.transferLimit = transferLimit;
    }

    @Override
    public String toString() {
        return "CommonUserDTO [uuid=" + super.getUuid() + ", transferLimit=" + transferLimit + "]";
    }

    @Override
    public void sending(Double value, BaseUser receiver) {
        System.out.println("Sending: " + value + " to: " + receiver);
    }

    @Override
    public void toReceive(Double value) {
        System.out.println("Receive: " + value);
    }

}
