package com.project.challenge.mstransfer.mstransfer.interfaces;

import com.project.challenge.mstransfer.mstransfer.DTOs.user.v1.UserBalanceDTO;

public interface ISender {

    Double getTransferLimit();

    UserBalanceDTO getUserBalanceDTO();

    void toSend(IReceiver receiver, Double value);
}