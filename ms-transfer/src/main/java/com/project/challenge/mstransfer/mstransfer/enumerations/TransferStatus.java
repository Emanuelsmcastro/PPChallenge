package com.project.challenge.mstransfer.mstransfer.enumerations;

import com.project.challenge.mstransfer.mstransfer.infra.exceptions.TransferStatusNotValid;

public enum TransferStatus {
    PENDING(0),
    SUCCESS(1),
    FAIL(2);

    private Integer value;

    TransferStatus(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public static TransferStatus valueOf(Integer value) {
        for (TransferStatus status : values()) {
            if (status.getValue().equals(value))
                return status;
        }
        throw new TransferStatusNotValid("Status (%d) not valid.".formatted(value));
    }
}
