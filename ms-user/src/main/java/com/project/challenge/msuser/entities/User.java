package com.project.challenge.msuser.entities;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.challenge.msuser.entities.abstracts.AbstractUser;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_user")
public class User extends AbstractUser {

    @Column(unique = true, nullable = false)
    private String cpfCNPJ;
    @Column(nullable = false)
    private Integer userType;
    private Double balance;
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    private ShopKeeper shopKeeper;
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    private CommonUser commonUser;

    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public User() {
    }

    public User(String cpfCNPJ, Integer userType, Double balance) {
        this.cpfCNPJ = cpfCNPJ;
        this.userType = userType;
        this.balance = balance;
    }

    public String getCpfCNPJ() {
        return cpfCNPJ;
    }

    public void setCpfCNPJ(String cpfCNPJ) {
        this.cpfCNPJ = cpfCNPJ;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public ShopKeeper getShopKeeper() {
        return shopKeeper;
    }

    public void setShopKeeper(ShopKeeper shopKeeper) {
        this.shopKeeper = shopKeeper;
    }

    public CommonUser getCommonUser() {
        return commonUser;
    }

    public void setCommonUser(CommonUser commonUser) {
        this.commonUser = commonUser;
    }

    public void addRole(Role role) {
        roles.add(role);
    }

    @Override
    public String toString() {
        String superString = super.toString();
        String thisString = " cpfCNPJ=" + cpfCNPJ + ", userType=" + userType + ", balance=" + balance
                + ", shopKeeper="
                + shopKeeper + ", commonUser=" + commonUser + ", roles=" + roles;
        return superString.replace("]", thisString);
    }

}
