package com.project.challenge.mstransfer.mstransfer.mappers.v2;

import java.util.List;
import java.util.stream.Collectors;

import com.project.challenge.mstransfer.mstransfer.DTOs.transfer.v2.TransferDTOWithHateoas;
import com.project.challenge.mstransfer.mstransfer.entities.Transfer;
import com.project.challenge.mstransfer.mstransfer.interfaces.Mapper;

public class MapperTransferWithHateoas implements Mapper<TransferDTOWithHateoas, Transfer> {
	private static final MapperTransferWithHateoas instance = new MapperTransferWithHateoas();

	public MapperTransferWithHateoas() {

    }

	public static MapperTransferWithHateoas getInstance() {
		return instance;
	}

	@Override
	public TransferDTOWithHateoas convert(Transfer entity) {
		return new TransferDTOWithHateoas(
                entity.getUuid(),
                entity.getValueToReceive(),
                entity.getUuidReceiver(),
                entity.getUuidSender(),
                entity.getInstant(),
                entity.getStatus());
	}

	@Override
	public List<TransferDTOWithHateoas> convertList(List<Transfer> entities) {
		return entities
                .stream()
                .map(
                        entity -> (convert(entity)))
                .collect(Collectors.toList());
	}

}
