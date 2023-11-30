package com.project.challenge.msuser.factories;

import java.util.UUID;

import com.project.challenge.msuser.entities.CommonUser;
import com.project.challenge.msuser.entities.Role;
import com.project.challenge.msuser.entities.ShopKeeper;
import com.project.challenge.msuser.entities.User;
import com.project.challenge.msuser.enumerations.UserType;

public class UserFactory {
    private static UserFactory instance = new UserFactory();
    private User user = new User();

    public UserFactory() {

    }

    public static UserFactory getInstance() {
        return instance;
    }

    public UserFactory setId(Long value) {
        user.setId(value);
        return this;
    }

    public UserFactory setUuid(UUID uuid) {
        user.setUuid(uuid.toString());
        return this;
    }

    public UserFactory autoUuid() {
        user.setUuid(UUID.randomUUID().toString());
        return this;
    }

    public UserFactory setFullName(String name) {
        user.setFullName(name);
        return this;
    }

    public UserFactory setEmail(String email) {
        user.setEmail(email);
        return this;
    }

    public UserFactory setPassword(String password) {
        user.setPassword(password);
        return this;
    }

    public UserFactory setcpfCNPJ(String cpfCNPJ) {
        user.setCpfCNPJ(cpfCNPJ);
        return this;
    }

    public UserFactory setUserType(UserType type) {
        user.setUserType(type);
        return this;
    }

    public UserFactory setBalance(Double balance) {
        user.setBalance(balance);
        return this;
    }

    public UserFactory setCommonUser(CommonUser commonUser) {
        user.setCommonUser(commonUser);
        return this;
    }

    public UserFactory setShopKeeper(ShopKeeper shopKeeper) {
        user.setShopKeeper(shopKeeper);
        return this;
    }

    public UserFactory addRoleToUser(Role role) {
        user.addRole(role);
        return this;
    }

    public User build() {
        return user;
    }
}
