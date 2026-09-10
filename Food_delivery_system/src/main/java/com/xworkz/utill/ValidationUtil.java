package com.xworkz.utill;

import com.mysql.cj.xdevapi.Schema;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class ValidationUtil {
    private static final ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();

    private static final Validator validator = validatorFactory.getValidator();

    public static Validator getValidator(){
        return validator;
    }
}
