package com.kwp.automatedbeantester.validtor;

/**
 * Created by Kenny on 02/10/2017.
 */
public class BeanValidatorFactory {

    public static BeanValidatorImpl getValidator()
    {
        return new BeanValidatorImpl();
    }

}
