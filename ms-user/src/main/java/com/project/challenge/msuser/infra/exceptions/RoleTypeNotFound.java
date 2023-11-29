package com.project.challenge.msuser.infra.exceptions;

public class RoleTypeNotFound extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public RoleTypeNotFound(String msg) {
        super(msg);
    }

}
