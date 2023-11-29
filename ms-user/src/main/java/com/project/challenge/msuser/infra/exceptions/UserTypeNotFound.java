package com.project.challenge.msuser.infra.exceptions;

public class UserTypeNotFound extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public UserTypeNotFound(String msg) {
        super(msg);
    }

}
