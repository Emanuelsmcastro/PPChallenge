package com.project.challenge.mstransfer.mstransfer.interfaces;

import com.project.challenge.mstransfer.mstransfer.DTOs.user.v1.UserBalanceDTO;

public interface IReceiver {

    UserBalanceDTO getUserBalanceDTO();

    void toReceive(Double value);
}