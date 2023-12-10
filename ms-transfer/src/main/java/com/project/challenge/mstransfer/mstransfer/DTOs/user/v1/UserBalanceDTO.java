package com.project.challenge.mstransfer.mstransfer.DTOs.user.v1;

import java.io.Serializable;

public class UserBalanceDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String uuid;
    private Double balance;

    public UserBalanceDTO() {
    }

    public UserBalanceDTO(String uuid, Double balance) {
        this.uuid = uuid;
        this.balance = balance;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "UserBalanceDTO [uuid=" + uuid + ", balance=" + balance + "]";
    }

}
