package com.project.challenge.msuser.infra.exceptions;

public class CommonUserNotFound extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public CommonUserNotFound(String msg) {
        super(msg);
    }

}
