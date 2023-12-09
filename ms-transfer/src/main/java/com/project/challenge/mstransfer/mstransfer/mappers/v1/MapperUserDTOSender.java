package com.project.challenge.mstransfer.mstransfer.mappers.v1;

import java.util.List;

import com.project.challenge.mstransfer.mstransfer.DTOs.user.v1.UserDTO;
import com.project.challenge.mstransfer.mstransfer.entities.Sender;
import com.project.challenge.mstransfer.mstransfer.interfaces.Mapper;

public class MapperUserDTOSender implements Mapper<Sender, UserDTO> {

    private static final MapperUserDTOSender instance = new MapperUserDTOSender();

    public MapperUserDTOSender() {

    }

    public static MapperUserDTOSender getInstance() {
        return instance;
    }

    @Override
    public Sender convert(UserDTO user) {
        return new Sender(
                user.getUuid(),
                user.getFullName(),
                user.getEmail(),
                user.getBalance(),
                user.getShopKeeper(),
                user.getCommonUser());
    }

    @Override
    public List<Sender> convertList(List<UserDTO> entities) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toDTOList'");
    }

}
