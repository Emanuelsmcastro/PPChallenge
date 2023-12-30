package com.project.challenge.mstransfer.mstransfer.entities;

import com.project.challenge.mstransfer.mstransfer.DTOs.user.v1.CommonUserDTO;
import com.project.challenge.mstransfer.mstransfer.DTOs.user.v1.ShopKeeperDTO;
import com.project.challenge.mstransfer.mstransfer.DTOs.user.v1.UserBalanceDTO;
import com.project.challenge.mstransfer.mstransfer.DTOs.user.v1.UserDTO;
import com.project.challenge.mstransfer.mstransfer.interfaces.IReceiver;
import com.project.challenge.mstransfer.mstransfer.interfaces.ISender;

public class Sender extends UserDTO implements ISender {
	private static final long serialVersionUID = 1L;

	public Sender() {

    }

    public Sender(String uuid, String fullName, String email, Double balance, ShopKeeperDTO shopKeeper,
            CommonUserDTO commonUser) {
        super(uuid, fullName, email, balance, shopKeeper, commonUser);
    }

    @Override
    public String toString() {
        return "Sender [uuid=" + super.getUuid() + ", email=" + super.getEmail() + ", shopKeeper="
                + super.getShopKeeper() + ", commonUser="
                + super.getCommonUser() + "]";
    }

    @Override
    public void toSend(IReceiver receiver, Double value) {
        super.setBalance(super.getBalance() - value);
        receiver.toReceive(value);
    }

    @Override
    public Double getTransferLimit() {
        return super.getCommonUser().getTransferLimit();
    }

    @Override
    public UserBalanceDTO getUserBalanceDTO() {
        return new UserBalanceDTO(
                super.getUuid(),
                super.getBalance());
    }

}
