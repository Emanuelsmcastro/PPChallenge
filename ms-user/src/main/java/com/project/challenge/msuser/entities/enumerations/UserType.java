package com.project.challenge.msuser.entities.enumerations;

public enum UserType {

    PF(0),
    PJ(1);

    private Integer value;

    UserType(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public UserType valueOf(Integer value) {
        for (UserType userType : values()) {
            if (userType.getValue().equals(value))
                return userType;
        }
        return null;
    }
}
