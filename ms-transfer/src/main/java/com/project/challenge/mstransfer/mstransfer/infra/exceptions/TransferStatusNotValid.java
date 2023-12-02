package com.project.challenge.mstransfer.mstransfer.infra.exceptions;

public class TransferStatusNotValid extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public TransferStatusNotValid(String msg) {
        super(msg);
    }

}
