package com.project.challenge.mstransfer.mstransfer.entities;

import java.io.Serializable;
import java.time.LocalTime;

import com.project.challenge.mstransfer.mstransfer.enumerations.TransferStatus;
import com.project.challenge.mstransfer.mstransfer.interfaces.IReceiving;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "tb_transfer")
public class Transfer implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String uuid;
    private Double valueToReceive;
    @Transient
    private IReceiving receiver;
    @Transient
    private SetSending sender;
    private String uuidReceiver;
    private String uuidSender;
    private LocalTime instant;
    private TransferStatus status;

    public Transfer() {
    }

    public Transfer(Long id, String uuid, Double valueToReceive, IReceiving receiver, SetSending sender,
            LocalTime instant, TransferStatus status) {
        this.id = id;
        this.uuid = uuid;
        this.valueToReceive = valueToReceive;
        this.receiver = receiver;
        this.sender = sender;
        this.uuidReceiver = receiver.getUuid();
        this.uuidSender = sender.getUuidSender();
        this.instant = instant;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUuidReceiver() {
        return uuidReceiver;
    }

    public void setUuidReceiver(String uuidReceiver) {
        this.uuidReceiver = uuidReceiver;
    }

    public String getUuidSender() {
        return uuidSender;
    }

    public void setUuidSender(String uuidSender) {
        this.uuidSender = uuidSender;
    }

    public Double getValueToReceive() {
        return valueToReceive;
    }

    public void setValueToReceive(Double valueToReceive) {
        this.valueToReceive = valueToReceive;
    }

    public LocalTime getInstant() {
        return instant;
    }

    public IReceiving getReceiver() {
        return receiver;
    }

    public void setReceiver(IReceiving receiver) {
        this.receiver = receiver;
    }

    public SetSending getSender() {
        return sender;
    }

    public void setSender(SetSending sender) {
        this.sender = sender;
    }

    public void setInstant(LocalTime instant) {
        this.instant = instant;
    }

    public TransferStatus getStatus() {
        return status;
    }

    public void setStatus(TransferStatus status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Transfer other = (Transfer) obj;
        if (uuid == null) {
            if (other.uuid != null)
                return false;
        } else if (!uuid.equals(other.uuid))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Transfer [id=" + id + ", uuid=" + uuid + ", valueToReceive=" + valueToReceive + ", receiver=" + receiver
                + ", sender=" + sender + ", instant=" + instant + ", status=" + status + "]";
    }

}
