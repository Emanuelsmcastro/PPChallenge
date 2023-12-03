package com.project.challenge.mstransfer.mstransfer.infra.exceptions;

public class TransferNotFound extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public TransferNotFound(String msg) {
        super(msg);
    }
}
