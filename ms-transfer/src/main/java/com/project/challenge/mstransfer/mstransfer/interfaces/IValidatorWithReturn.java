package com.project.challenge.mstransfer.mstransfer.interfaces;

import java.util.Map;

public interface IValidatorWithReturn<T> extends IValidator<T> {

    Map<String, ?> executeValidationWithReturn(T obj);
}
