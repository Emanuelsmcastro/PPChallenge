package com.project.challenge.mstransfer.mstransfer.infra.exceptions;

public class ExternalServiceException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExternalServiceException(String msg) {
        super(msg);
    }
}
