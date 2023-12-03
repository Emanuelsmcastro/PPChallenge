package com.project.challenge.msuser.factories;

import java.util.UUID;

import com.project.challenge.msuser.entities.CommonUser;

public class CommonUserFactory {
    private static CommonUserFactory instance = new CommonUserFactory();
    private CommonUser user = new CommonUser();

    public CommonUserFactory() {

    }

    public static CommonUserFactory getInstance() {
        return instance;
    }

    public CommonUserFactory setId(Long value) {
        user.setId(value);
        return this;
    }

    public CommonUserFactory setUuid(UUID uuid) {
        user.setUuid(uuid.toString());
        return this;
    }

    public CommonUserFactory autoUuid() {
        user.setUuid(UUID.randomUUID().toString());
        return this;
    }

    public CommonUserFactory setTransferLimit(Double limit) {
        user.setTransferLimit(limit);
        return this;
    }

    public CommonUser build() {
        CommonUser currentUser = user;
        user = new CommonUser();
        return currentUser;
    }
}
