package com.project.challenge.msuser.entities;

import java.io.Serializable;

import com.project.challenge.msuser.interfaces.IReceiving;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_shop_keeper")
public class ShopKeeper implements IReceiving, Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String uuid;
    private Integer yearsInTheCompany;

    @OneToOne(mappedBy = "shopKeeper", fetch = FetchType.EAGER)
    private User user;

    public ShopKeeper() {
    }

    public ShopKeeper(Long id, String uuid, Integer yearsInTheCompany) {
        this.id = id;
        this.uuid = uuid;
        this.yearsInTheCompany = yearsInTheCompany;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Integer getYearsInTheCompany() {
        return yearsInTheCompany;
    }

    public void setYearsInTheCompany(Integer yearsInTheCompany) {
        this.yearsInTheCompany = yearsInTheCompany;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ShopKeeper other = (ShopKeeper) obj;
        if (uuid == null) {
            if (other.uuid != null)
                return false;
        } else if (!uuid.equals(other.uuid))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ShopKeeper [id=" + id + ", uuid=" + uuid + ", yearsInTheCompany=" + yearsInTheCompany + "]";
    }

    @Override
    public void toReceive(Double value) {
        System.out.println("Receive: " + value);
    }

}
