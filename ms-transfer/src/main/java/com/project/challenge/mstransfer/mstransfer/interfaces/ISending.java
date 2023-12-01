package com.project.challenge.mstransfer.mstransfer.interfaces;

public interface ISending<T> {

    String getUuid();

    void sending(Double value, T receiver);
}
