package com.project.challenge.mstransfer.mstransfer.entities;

import java.io.Serializable;

public class SetSending implements Serializable {
    private static final long serialVersionUID = 1L;

    private String uuidSender;
    private Double valueToSend;

    public SetSending() {
    }

    public SetSending(String uuidSender, Double valueToSend) {
        this.uuidSender = uuidSender;
        this.valueToSend = valueToSend;
    }

    public String getUuidSender() {
        return uuidSender;
    }

    public void setUuidSender(String uuidSender) {
        this.uuidSender = uuidSender;
    }

    public Double getValueToSend() {
        return valueToSend;
    }

    public void setValueToSend(Double valueToSend) {
        this.valueToSend = valueToSend;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((uuidSender == null) ? 0 : uuidSender.hashCode());
        result = prime * result + ((valueToSend == null) ? 0 : valueToSend.hashCode());
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
        SetSending other = (SetSending) obj;
        if (uuidSender == null) {
            if (other.uuidSender != null)
                return false;
        } else if (!uuidSender.equals(other.uuidSender))
            return false;
        if (valueToSend == null) {
            if (other.valueToSend != null)
                return false;
        } else if (!valueToSend.equals(other.valueToSend))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "SetSending [uuidSender=" + uuidSender + ", valueToSend=" + valueToSend + "]";
    }

}
