package com.example.productorderserver.validator;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;



public class AbstractValidator<T> implements Validator {
	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}
	
	@SuppressWarnings("unchecked")
    @Override
    public void validate(Object target, Errors errors) {
        try {
            doValidate((T) target, errors);
        } catch(RuntimeException e) {
            log.error("중복 검증 에러", e);
            throw e;
        }
    }

    protected abstract void doValidate(final T dto, final Errors errors);
}
