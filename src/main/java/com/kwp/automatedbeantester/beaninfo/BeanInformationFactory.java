package com.kwp.automatedbeantester.beaninfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Kenny on 30/09/2017.
 */
public class BeanInformationFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(BeanInformationFactory.class);

    public static BeanInformation getInstance(Class beanClass) throws BeanProcessingException {

        LOGGER.info("Creating BeanInformationImpl instance for class {}",beanClass.getName());

        BeanInformation beanInfo = new BeanInformationImpl(beanClass);

        return beanInfo;
    }

}
