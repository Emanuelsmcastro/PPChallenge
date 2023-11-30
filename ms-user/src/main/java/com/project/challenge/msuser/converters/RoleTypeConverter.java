package com.project.challenge.msuser.converters;

import com.project.challenge.msuser.enumerations.RoleType;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class RoleTypeConverter implements AttributeConverter<RoleType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(RoleType roleType) {
        if (roleType == null)
            return null;
        return roleType.getValue();
    }

    @Override
    public RoleType convertToEntityAttribute(Integer dbData) {
        if (dbData == null)
            return null;
        return RoleType.valueOf(dbData);
    }

}
