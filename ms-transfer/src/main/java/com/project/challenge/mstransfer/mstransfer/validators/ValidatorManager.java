package com.project.challenge.mstransfer.mstransfer.validators;

import java.util.HashMap;
import java.util.Map;

import org.springframework.util.ObjectUtils;

import com.project.challenge.mstransfer.mstransfer.interfaces.IValidator;
import com.project.challenge.mstransfer.mstransfer.interfaces.IValidatorWithReturn;

public class ValidatorManager<T> {

    private IValidator<T>[] validators;
    private Map<String, IValidatorWithReturn<T>> mapValidators = new HashMap<>();

    private Map<String, Map<String, ?>> mapResults = new HashMap<>();

    public ValidatorManager() {
    }

    @SafeVarargs
    public ValidatorManager(IValidator<T>... validators) {
        this.validators = validators;
    }

    public IValidator<T>[] getValidators() {
        return validators;
    }

    public Map<String, Map<String, ?>> getMapResults() {
        return mapResults;
    }

    public void executeAll(T object) {
        for (IValidator<T> validator : validators) {
            validator.execute(object);
        }
    }

    public ValidatorManager<T> addMapValidator(IValidatorWithReturn<T> validator) {
        mapValidators.put(validator.getClass().getSimpleName(), validator);
        return this;
    }

    public ValidatorManager<T> executeMapValidation(T object) {
        for (Map.Entry<String, IValidatorWithReturn<T>> entry : mapValidators.entrySet()) {
            Map<String, ?> result = entry.getValue().executeValidationWithReturn(object);
            if (!ObjectUtils.isEmpty(result))
                mapResults.put(entry.getKey(), entry.getValue().executeValidationWithReturn(object));
        }
        return this;
    }
}
