package com.project.challenge.mstransfer.mstransfer.entities;

import com.project.challenge.mstransfer.mstransfer.DTOs.user.v1.CommonUserDTO;
import com.project.challenge.mstransfer.mstransfer.DTOs.user.v1.ShopKeeperDTO;
import com.project.challenge.mstransfer.mstransfer.DTOs.user.v1.UserBalanceDTO;
import com.project.challenge.mstransfer.mstransfer.DTOs.user.v1.UserDTO;
import com.project.challenge.mstransfer.mstransfer.interfaces.IReceiver;

public class Receiver extends UserDTO implements IReceiver {
	private static final long serialVersionUID = 1L;

	public Receiver() {

    }

    public Receiver(String uuid, String fullName, String email, Double balance, ShopKeeperDTO shopKeeper,
            CommonUserDTO commonUser) {
        super(uuid, fullName, email, balance, shopKeeper, commonUser);
    }

    @Override
    public UserBalanceDTO getUserBalanceDTO() {
        return new UserBalanceDTO(
                super.getUuid(),
                super.getBalance());
    }

    @Override
    public String toString() {
        return "Receiver [uuid=" + super.getUuid() + ", email=" + super.getEmail() + ", shopKeeper="
                + super.getShopKeeper() + ", commonUser="
                + super.getCommonUser() + "]";
    }

    @Override
    public void toReceive(Double value) {
        super.setBalance(super.getBalance() + value);
    }

}
