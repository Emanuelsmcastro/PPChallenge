package com.project.challenge.msuser.factories;

import java.util.UUID;

import com.project.challenge.msuser.entities.ShopKeeper;

public class ShopKeeperFactory {
    private static ShopKeeperFactory instance = new ShopKeeperFactory();
    private ShopKeeper user = new ShopKeeper();

    public ShopKeeperFactory() {
    }

    public static ShopKeeperFactory getInstance() {
        return instance;
    }

    public ShopKeeperFactory setId(Long value) {
        user.setId(value);
        return this;
    }

    public ShopKeeperFactory setUuid(UUID uuid) {
        user.setUuid(uuid.toString());
        return this;
    }

    public ShopKeeperFactory autoUuid() {
        user.setUuid(UUID.randomUUID().toString());
        return this;
    }

    public ShopKeeperFactory setYearsInTheCompany(Integer years) {
        user.setYearsInTheCompany(years);
        return this;
    }

    public ShopKeeper build() {
        ShopKeeper currentUser = user;
        user = new ShopKeeper();
        return currentUser;
    }
}
