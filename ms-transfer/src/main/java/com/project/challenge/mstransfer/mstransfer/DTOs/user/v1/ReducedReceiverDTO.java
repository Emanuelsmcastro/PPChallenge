package com.project.challenge.mstransfer.mstransfer.DTOs.user.v1;

import java.io.Serializable;

public class ReducedReceiverDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String uuid;

    public ReducedReceiverDTO() {

    }

    public ReducedReceiverDTO(String uuid) {
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
        return "ReducedReceiverDTO [uuid=" + uuid + "]";
    }

}
