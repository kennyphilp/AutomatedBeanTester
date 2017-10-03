package com.kwp.automatedbeantester.beaninfo;

/**
 * Created by Kenny on 30/09/2017.
 */
public class BeanProcessingException extends Exception {

    public BeanProcessingException(Exception e) {
        super(e);
    }

    public BeanProcessingException(String message, Throwable cause) {
        super(message, cause);
    }

    public BeanProcessingException(String message) {
        super(message);
    }

}
