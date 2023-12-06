package com.project.challenge.mstransfer.mstransfer.DTOs.user.v1;

public class ShopKeeperDTO extends ReceiverBaseDTO {

    private Integer yearsInTheCompany;

    public ShopKeeperDTO() {

    }

    public ShopKeeperDTO(String uuid, Integer yearsInTheCompany) {
        super(uuid);
        this.yearsInTheCompany = yearsInTheCompany;
    }

    public Integer getYearsInTheCompany() {
        return yearsInTheCompany;
    }

    public void setYearsInTheCompany(Integer yearsInTheCompany) {
        this.yearsInTheCompany = yearsInTheCompany;
    }

    @Override
    public String toString() {
        return "ShopKeeperDTO [uuid=" + super.getUuid() + ", yearsInTheCompany=" + yearsInTheCompany + "]";
    }

    @Override
    public void toReceive(Double value) {
        System.out.println("Receive: " + value);
    }

}
