package com.project.challenge.mstransfer.mstransfer.validators;

import com.project.challenge.mstransfer.mstransfer.clients.MockClient;
import com.project.challenge.mstransfer.mstransfer.infra.exceptions.ExternalServiceException;
import com.project.challenge.mstransfer.mstransfer.interfaces.IValidator;

public class MockAuthValidation implements IValidator<String> {

    private MockClient mockClient;

    public MockAuthValidation() {
    }

    public MockAuthValidation(MockClient mockClient) {
        this.mockClient = mockClient;
    }

    @Override
    public void execute(String obj) {
        if (!mockClient.getMockAuth().getBody().message().equals(obj))
            throw new ExternalServiceException("Unauthorized transaction.");

    }

}
