package com.project.challenge.msuser.converters;

import com.project.challenge.msuser.enumerations.UserType;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class UserTypeConverter implements AttributeConverter<UserType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(UserType roleType) {
        if (roleType == null)
            return null;
        return roleType.getValue();
    }

    @Override
    public UserType convertToEntityAttribute(Integer dbData) {
        if (dbData == null)
            return null;
        return UserType.valueOf(dbData);
    }

}
