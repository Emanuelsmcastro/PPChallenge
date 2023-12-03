package com.project.challenge.mstransfer.mstransfer.factories;

import java.time.LocalTime;
import java.util.UUID;

import com.project.challenge.mstransfer.mstransfer.entities.SetSending;
import com.project.challenge.mstransfer.mstransfer.entities.Transfer;
import com.project.challenge.mstransfer.mstransfer.enumerations.TransferStatus;
import com.project.challenge.mstransfer.mstransfer.interfaces.IReceiving;

public class TransferFactory {
    private static final TransferFactory instance = new TransferFactory();
    private Transfer transfer = new Transfer();

    public TransferFactory() {
    }

    public static TransferFactory getInstance() {
        return instance;
    }

    public TransferFactory setId(Long id) {
        transfer.setId(id);
        return this;
    }

    public TransferFactory setUuid(String uuid) {
        transfer.setUuid(uuid);
        return this;
    }

    public TransferFactory autoUuid() {
        transfer.setUuid(UUID.randomUUID().toString());
        return this;
    }

    public TransferFactory setValueToReceive(Double value) {
        transfer.setValueToReceive(value);
        return this;
    }

    public TransferFactory setReceiver(IReceiving receiver) {
        transfer.setUuidReceiver(receiver.getUuid());
        return this;
    }

    public TransferFactory setSender(SetSending sender) {
        transfer.setUuidSender(sender.getUuidSender());
        return this;
    }

    public TransferFactory setTime(LocalTime time) {
        transfer.setInstant(time);
        return this;
    }

    public TransferFactory setNow() {
        transfer.setInstant(LocalTime.now());
        return this;
    }

    public TransferFactory setStatus(TransferStatus status) {
        transfer.setStatus(status);
        return this;
    }

    public Transfer build() {
        Transfer currentTransfer = transfer;
        transfer = new Transfer();
        return currentTransfer;
    }
}
