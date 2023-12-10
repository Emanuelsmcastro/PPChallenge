package com.project.challenge.mstransfer.mstransfer.mappers.v1;

import java.util.List;

import com.project.challenge.mstransfer.mstransfer.DTOs.user.v1.UserDTO;
import com.project.challenge.mstransfer.mstransfer.entities.Receiver;
import com.project.challenge.mstransfer.mstransfer.interfaces.Mapper;

public class MapperUserDTOReceiver implements Mapper<Receiver, UserDTO> {

    private static final MapperUserDTOReceiver instance = new MapperUserDTOReceiver();

    public MapperUserDTOReceiver() {

    }

    public static MapperUserDTOReceiver getInstance() {
        return instance;
    }

    @Override
    public Receiver convert(UserDTO user) {
        return new Receiver(
                user.getUuid(),
                user.getFullName(),
                user.getEmail(),
                user.getBalance(),
                user.getShopKeeper(),
                user.getCommonUser());
    }

    @Override
    public List<Receiver> convertList(List<UserDTO> entities) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toDTOList'");
    }

}
