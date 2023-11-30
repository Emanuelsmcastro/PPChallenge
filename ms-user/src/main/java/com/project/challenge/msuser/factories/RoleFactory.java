package com.project.challenge.msuser.factories;

import java.util.UUID;

import com.project.challenge.msuser.entities.Role;
import com.project.challenge.msuser.enumerations.RoleType;

public class RoleFactory {
    private static final RoleFactory instance = new RoleFactory();
    private Role role = new Role();

    public RoleFactory() {

    }

    public static RoleFactory getInstance() {
        return instance;
    }

    public RoleFactory setId(Long id) {
        role.setId(id);
        return this;
    }

    public RoleFactory setUuid(String uuid) {
        role.setUuid(uuid);
        return this;
    }

    public RoleFactory autoUuid() {
        role.setUuid(UUID.randomUUID().toString());
        return this;
    }

    public RoleFactory setRoleType(RoleType type) {
        role.setRoleType(type);
        return this;
    }

    public Role build() {
        return role;
    }

}
