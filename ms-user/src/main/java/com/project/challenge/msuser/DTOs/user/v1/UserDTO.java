package com.project.challenge.msuser.DTOs.user.v1;

import java.io.Serializable;

public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String uuid;
    private String fullName;
    private String email;
    private ShopKeeperDTO shopKeeper;
    private CommonUserDTO commonUser;

    public UserDTO() {
    }

    public UserDTO(String uuid, String fullName, String email, ShopKeeperDTO shopKeeper, CommonUserDTO commonUser) {
        this.uuid = uuid;
        this.fullName = fullName;
        this.email = email;
        this.shopKeeper = shopKeeper;
        this.commonUser = commonUser;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public ShopKeeperDTO getShopKeeper() {
        return shopKeeper;
    }

    public void setShopKeeper(ShopKeeperDTO shopKeeper) {
        this.shopKeeper = shopKeeper;
    }

    public CommonUserDTO getCommonUser() {
        return commonUser;
    }

    public void setCommonUser(CommonUserDTO commonUser) {
        this.commonUser = commonUser;
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
        UserDTO other = (UserDTO) obj;
        if (uuid == null) {
            if (other.uuid != null)
                return false;
        } else if (!uuid.equals(other.uuid))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "UserDTO [uuid=" + uuid + ", email=" + email + ", shopKeeper=" + shopKeeper + ", commonUser="
                + commonUser + "]";
    }

}
