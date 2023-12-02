package com.project.challenge.mstransfer.mstransfer.DTOs.user.v1;

import java.io.Serializable;

public class ReducedCommonUserDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String uuid;

    public ReducedCommonUserDTO() {

    }

    public ReducedCommonUserDTO(String uuid) {
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        return "ReducedCommonUserDTO [uuid=" + uuid + "]";
    }

}
