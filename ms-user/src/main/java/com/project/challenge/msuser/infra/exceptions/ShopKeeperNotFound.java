package com.project.challenge.msuser.infra.exceptions;

public class ShopKeeperNotFound extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ShopKeeperNotFound(String msg) {
        super(msg);
    }

}
