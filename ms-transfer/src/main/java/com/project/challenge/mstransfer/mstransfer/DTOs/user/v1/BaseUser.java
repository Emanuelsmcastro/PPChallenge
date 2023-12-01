package com.project.challenge.mstransfer.mstransfer.DTOs.user.v1;

import java.io.Serializable;

public abstract class BaseUser implements Serializable {

    private static final long serialVersionUID = 1L;

    private String uuid;

    public BaseUser() {
    }

    public BaseUser(String uuid) {
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
