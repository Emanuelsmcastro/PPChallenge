package com.project.challenge.mstransfer.mstransfer.converter;

import com.project.challenge.mstransfer.mstransfer.enumerations.TransferStatus;

import jakarta.persistence.AttributeConverter;

public class TransferStatusConverter implements AttributeConverter<TransferStatus, Integer> {

    @Override
    public Integer convertToDatabaseColumn(TransferStatus attribute) {
        return attribute.getValue();
    }

    @Override
    public TransferStatus convertToEntityAttribute(Integer dbData) {
        return TransferStatus.valueOf(dbData);
    }

}
