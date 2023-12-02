package com.project.challenge.msuser.DTOs.user.v1;

import java.io.Serializable;

public class ShopKeeperDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String uuid;
    private Integer yearsInTheCompany;

    public ShopKeeperDTO() {

    }

    public ShopKeeperDTO(String uuid, Integer yearsInTheCompany) {
        this.uuid = uuid;
        this.yearsInTheCompany = yearsInTheCompany;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Integer getYearsInTheCompany() {
        return yearsInTheCompany;
    }

    public void setYearsInTheCompany(Integer yearsInTheCompany) {
        this.yearsInTheCompany = yearsInTheCompany;
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
        ShopKeeperDTO other = (ShopKeeperDTO) obj;
        if (uuid == null) {
            if (other.uuid != null)
                return false;
        } else if (!uuid.equals(other.uuid))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ShopKeeperDTO [uuid=" + uuid + ", yearsInTheCompany=" + yearsInTheCompany + "]";
    }

}
