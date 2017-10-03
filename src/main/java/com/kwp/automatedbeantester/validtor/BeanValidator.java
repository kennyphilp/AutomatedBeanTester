package com.kwp.automatedbeantester.validtor;

import com.kwp.automatedbeantester.beaninfo.BeanInformation;
import com.kwp.automatedbeantester.beaninfo.BeanProcessingException;

/**
 * Created by Kenny on 02/10/2017.
 */
public interface BeanValidator {

    boolean validate(BeanInformation beanInfo) throws BeanProcessingException;

}
