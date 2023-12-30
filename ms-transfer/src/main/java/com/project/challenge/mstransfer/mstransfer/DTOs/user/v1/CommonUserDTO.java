package com.project.challenge.mstransfer.mstransfer.DTOs.user.v1;

public class CommonUserDTO extends BaseUser {
	private static final long serialVersionUID = 1L;
	private Double transferLimit;

    public CommonUserDTO() {

    }

    public CommonUserDTO(String uuid, Double transferLimit) {
        super(uuid);
        this.transferLimit = transferLimit;
    }

    public Double getTransferLimit() {
        return transferLimit;
    }

    public void setTransferLimit(Double transferLimit) {
        this.transferLimit = transferLimit;
    }

    @Override
    public String toString() {
        return "CommonUserDTO [uuid=" + super.getUuid() + ", transferLimit=" + transferLimit + "]";
    }

}
