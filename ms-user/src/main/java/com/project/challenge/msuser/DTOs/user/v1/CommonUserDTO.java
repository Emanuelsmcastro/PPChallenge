package com.project.challenge.msuser.DTOs.user.v1;

import java.io.Serializable;

public class CommonUserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String uuid;
    private Double transferLimit;

    public CommonUserDTO() {

    }

    public CommonUserDTO(String uuid, Double transferLimit) {
        this.uuid = uuid;
        this.transferLimit = transferLimit;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Double getTransferLimit() {
        return transferLimit;
    }

    public void setTransferLimit(Double transferLimit) {
        this.transferLimit = transferLimit;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CommonUserDTO other = (CommonUserDTO) obj;
        if (uuid == null) {
            if (other.uuid != null)
                return false;
        } else if (!uuid.equals(other.uuid))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "CommonUserDTO [uuid=" + uuid + ", transferLimit=" + transferLimit + "]";
    }

}
