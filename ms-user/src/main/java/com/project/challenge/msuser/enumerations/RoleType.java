package com.project.challenge.msuser.enumerations;

import com.project.challenge.msuser.infra.exceptions.RoleTypeNotFound;

public enum RoleType {
    BASIC(0),
    ADMIN(1);

    private Integer value;

    RoleType(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public static RoleType valueOf(Integer value) {
        for (RoleType roleType : values()) {
            if (roleType.getValue().equals(value))
                return roleType;
        }
        throw new RoleTypeNotFound(String.format("Type %d not found.", value));
    }
}
