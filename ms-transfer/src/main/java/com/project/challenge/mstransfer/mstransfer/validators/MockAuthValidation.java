package com.project.challenge.mstransfer.mstransfer.validators;

import com.project.challenge.mstransfer.mstransfer.clients.MockClient;
import com.project.challenge.mstransfer.mstransfer.entities.Transfer;
import com.project.challenge.mstransfer.mstransfer.infra.exceptions.ExternalServiceException;
import com.project.challenge.mstransfer.mstransfer.interfaces.IValidator;

public class MockAuthValidation implements IValidator<Transfer> {

    private MockClient mockClient;

    public MockAuthValidation() {
    }

    public MockAuthValidation(MockClient mockClient) {
        this.mockClient = mockClient;
    }

    @Override
    public void execute(Transfer transfer) {
        if (!mockClient.getMockAuth().getBody().message().equals("Autorizado"))
            throw new ExternalServiceException("Unauthorized transaction.");

    }

}
