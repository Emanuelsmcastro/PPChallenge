package com.project.challenge.msuser.enumerations;

import com.project.challenge.msuser.infra.exceptions.RoleTypeNotFound;

public enum RoleType {
    PF(0),
    PJ(1);

    private Integer value;

    RoleType(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public RoleType valueOf(Integer value) {
        for (RoleType roleType : values()) {
            if (roleType.getValue().equals(value))
                return roleType;
        }
        throw new RoleTypeNotFound(String.format("Type %d not found.", value));
    }
}
