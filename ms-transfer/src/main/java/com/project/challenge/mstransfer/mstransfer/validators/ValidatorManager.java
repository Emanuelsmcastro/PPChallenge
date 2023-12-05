package com.project.challenge.mstransfer.mstransfer.validators;

import com.project.challenge.mstransfer.mstransfer.interfaces.IValidator;

public class ValidatorManager<T> {

    public IValidator<T>[] validators;

    public ValidatorManager() {
    }

    @SafeVarargs
    public ValidatorManager(IValidator<T>... validators) {
        this.validators = validators;
    }

    public IValidator<T>[] getValidators() {
        return validators;
    }

    public void executeAll(T object) {
        for (IValidator<T> validator : validators) {
            validator.execute(object);
        }
    }
}
