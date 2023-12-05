package com.project.challenge.mstransfer.mstransfer.infra.exceptions;

public class TransferValueException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public TransferValueException(String msg) {
        super(msg);
    }
}
