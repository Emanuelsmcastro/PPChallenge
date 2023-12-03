package com.project.challenge.mstransfer.mstransfer.DTOs.user.transfer.v1;

import java.time.LocalTime;

import com.project.challenge.mstransfer.mstransfer.enumerations.TransferStatus;

public class TransferDTO {

    private String uuid;
    private Double valueToReceive;
    private String uuidReceiver;
    private String uuidSender;
    private LocalTime instant;
    private TransferStatus status;

    public TransferDTO() {
    }

    public TransferDTO(String uuid, Double valueToReceive, String uuidReceiver, String uuidSender,
            LocalTime instant, TransferStatus status) {
        this.uuid = uuid;
        this.valueToReceive = valueToReceive;
        this.uuidReceiver = uuidReceiver;
        this.uuidSender = uuidSender;
        this.instant = instant;
        this.status = status;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Double getValueToReceive() {
        return valueToReceive;
    }

    public void setValueToReceive(Double valueToReceive) {
        this.valueToReceive = valueToReceive;
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

    public LocalTime getInstant() {
        return instant;
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
        TransferDTO other = (TransferDTO) obj;
        if (uuid == null) {
            if (other.uuid != null)
                return false;
        } else if (!uuid.equals(other.uuid))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "TransferDTO [uuid=" + uuid + ", valueToReceive=" + valueToReceive + ", uuidReceiver=" + uuidReceiver
                + ", uuidSender=" + uuidSender + ", instant=" + instant + ", status="
                + status + "]";
    }

}
