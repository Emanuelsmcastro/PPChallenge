package com.project.challenge.mstransfer.mstransfer.DTOs.transfer.v1;

import java.io.Serializable;

import com.project.challenge.mstransfer.mstransfer.DTOs.user.v1.ReducedReceiverDTO;
import com.project.challenge.mstransfer.mstransfer.entities.SetSending;

public class TransferRequestDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Double valueToReceive;
    private ReducedReceiverDTO receiver;
    private SetSending sender;

    public TransferRequestDTO() {
    }

    public TransferRequestDTO(Double valueToReceive, ReducedReceiverDTO receiver, SetSending sender) {
        this.valueToReceive = valueToReceive;
        this.receiver = receiver;
        this.sender = sender;
    }

    public Double getValueToReceive() {
        return valueToReceive;
    }

    public void setValueToReceive(Double valueToReceive) {
        this.valueToReceive = valueToReceive;
    }

    public ReducedReceiverDTO getReceiver() {
        return receiver;
    }

    public void setReceiver(ReducedReceiverDTO receiver) {
        this.receiver = receiver;
    }

    public SetSending getSender() {
        return sender;
    }

    public void setSender(SetSending sender) {
        this.sender = sender;
    }

    @Override
    public String toString() {
        return "TransferRequestDTO [valueToReceive=" + valueToReceive + ", receiver=" + receiver + ", sender="
                + sender + "]";
    }

}
