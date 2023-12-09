package com.project.challenge.mstransfer.mstransfer.entities;

import java.io.Serializable;

import com.project.challenge.mstransfer.mstransfer.interfaces.IReceiver;
import com.project.challenge.mstransfer.mstransfer.interfaces.ISender;

public class Checkout implements Serializable {
    private static final long serialVersionUID = 1L;

    private Double transferValue;
    private IReceiver receiver;
    private ISender sender;

    public Checkout() {
    }

    public Checkout(Double transferValue, IReceiver receiver, ISender sender) {
        this.transferValue = transferValue;
        this.receiver = receiver;
        this.sender = sender;
    }

    public Double getTransferValue() {
        return transferValue;
    }

    public void setTransferValue(Double transferValue) {
        this.transferValue = transferValue;
    }

    public IReceiver getReceiver() {
        return receiver;
    }

    public void setReceiver(IReceiver receiver) {
        this.receiver = receiver;
    }

    public ISender getSender() {
        return sender;
    }

    public void setSender(ISender sender) {
        this.sender = sender;
    }

    @Override
    public String toString() {
        return "Checkout [transferValue=" + transferValue + ", receiver=" + receiver + ", sender=" + sender + "]";
    }

}
