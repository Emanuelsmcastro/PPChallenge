package com.project.challenge.msuser.entities;

import com.project.challenge.msuser.entities.abstracts.AbstractUser;
import com.project.challenge.msuser.entities.enumerations.UserType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_user")
public class User extends AbstractUser {

    @Column(unique = true, nullable = false)
    private String cpfCNPJ;
    @Column(nullable = false)
    private UserType userType;
    private Double balance;

    public User() {
    }

    public User(String cpfCNPJ, UserType userType, Double balance) {
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

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

}
