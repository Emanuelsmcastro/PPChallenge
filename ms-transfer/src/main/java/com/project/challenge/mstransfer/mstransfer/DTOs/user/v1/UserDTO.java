package com.project.challenge.mstransfer.mstransfer.DTOs.user.v1;

public class UserDTO extends BaseUser {
    private static final long serialVersionUID = 1L;

    private String fullName;
    private String email;
    private Double balance;
    private ShopKeeperDTO shopKeeper;
    private CommonUserDTO commonUser;

    public UserDTO() {
        super();
    }

    public UserDTO(String uuid, String fullName, String email, Double balance, ShopKeeperDTO shopKeeper,
            CommonUserDTO commonUser) {
        super(uuid);
        this.fullName = fullName;
        this.email = email;
        this.balance = balance;
        this.shopKeeper = shopKeeper;
        this.commonUser = commonUser;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
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
    public String toString() {
        return "UserDTO [uuid=" + super.getUuid() + ", email=" + email + ", shopKeeper=" + shopKeeper + ", commonUser="
                + commonUser + "]";
    }

}
