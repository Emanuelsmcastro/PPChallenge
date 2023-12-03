package com.project.challenge.mstransfer.mstransfer.mappers.v1;

import java.util.List;
import java.util.stream.Collectors;

import com.project.challenge.mstransfer.mstransfer.DTOs.transfer.v1.TransferDTO;
import com.project.challenge.mstransfer.mstransfer.entities.Transfer;
import com.project.challenge.mstransfer.mstransfer.interfaces.Mapper;

public class MapperTransfer implements Mapper<TransferDTO, Transfer> {
    private static final MapperTransfer instance = new MapperTransfer();

    public MapperTransfer() {

    }

    public static MapperTransfer getInstance() {
        return instance;
    }

    @Override
    public TransferDTO toDTO(Transfer entity) {
        return new TransferDTO(
                entity.getUuid(),
                entity.getValueToReceive(),
                entity.getUuidReceiver(),
                entity.getUuidSender(),
                entity.getInstant(),
                entity.getStatus());

    }

    @Override
    public List<TransferDTO> toDTOList(List<Transfer> entities) {
        return entities
                .stream()
                .map(
                        entity -> (toDTO(entity)))
                .collect(Collectors.toList());
    }

}
