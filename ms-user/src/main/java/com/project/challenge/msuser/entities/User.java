package com.project.challenge.msuser.entities;

import java.util.HashSet;
import java.util.Set;

import com.project.challenge.msuser.entities.abstracts.AbstractUser;
import com.project.challenge.msuser.entities.enumerations.UserType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_user")
public class User extends AbstractUser {

    @Column(unique = true, nullable = false)
    private String cpfCNPJ;
    @Column(nullable = false)
    private UserType userType;
    private Double balance;

    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

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
