package com.project.challenge.mstransfer.mstransfer.DTOs.transfer.v1;

import java.io.Serializable;

import com.project.challenge.mstransfer.mstransfer.DTOs.user.v1.ReducedShopKeeperDTO;
import com.project.challenge.mstransfer.mstransfer.entities.SetSending;

public class TransferRequestDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Double valueToReceive;
    private ReducedShopKeeperDTO shopKeeper;
    private SetSending sender;

    public TransferRequestDTO() {
    }

    public TransferRequestDTO(Double valueToReceive, ReducedShopKeeperDTO shopKeeper, SetSending sender) {
        this.valueToReceive = valueToReceive;
        this.shopKeeper = shopKeeper;
        this.sender = sender;
    }

    public Double getValueToReceive() {
        return valueToReceive;
    }

    public void setValueToReceive(Double valueToReceive) {
        this.valueToReceive = valueToReceive;
    }

    public ReducedShopKeeperDTO getShopKeeper() {
        return shopKeeper;
    }

    public void setShopKeeper(ReducedShopKeeperDTO shopKeeper) {
        this.shopKeeper = shopKeeper;
    }

    public SetSending getSender() {
        return sender;
    }

    public void setSender(SetSending sender) {
        this.sender = sender;
    }

    @Override
    public String toString() {
        return "TransferRequestDTO [valueToReceive=" + valueToReceive + ", shopKeeper=" + shopKeeper + ", sender="
                + sender + "]";
    }

}
