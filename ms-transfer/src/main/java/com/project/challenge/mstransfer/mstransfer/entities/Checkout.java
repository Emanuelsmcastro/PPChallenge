package com.project.challenge.mstransfer.mstransfer.entities;

import java.io.Serializable;

import com.project.challenge.mstransfer.mstransfer.DTOs.user.v1.UserDTO;

public class Checkout implements Serializable {
    private static final long serialVersionUID = 1L;

    private Double transferValue;
    private UserDTO receiver;
    private UserDTO sender;

    public Checkout() {
    }

    public Checkout(Double transferValue, UserDTO receiver, UserDTO sender) {
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

    public UserDTO getReceiver() {
        return receiver;
    }

    public void setReceiver(UserDTO receiver) {
        this.receiver = receiver;
    }

    public UserDTO getSender() {
        return sender;
    }

    public void setSender(UserDTO sender) {
        this.sender = sender;
    }

    @Override
    public String toString() {
        return "Checkout [transferValue=" + transferValue + ", receiver=" + receiver + ", sender=" + sender + "]";
    }

}
