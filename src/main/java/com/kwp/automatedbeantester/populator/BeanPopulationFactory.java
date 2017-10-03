package com.kwp.automatedbeantester.populator;

import com.kwp.automatedbeantester.beaninfo.BeanProcessingException;
import com.kwp.automatedbeantester.values.ValueGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Kenny on 30/09/2017.
 */
public class BeanPopulationFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(BeanPopulationFactory.class);

    private ValueGenerator valueGenerator;

    public BeanPopulationFactory() {
    }

    public static BeanPopulator generateBeanPopulator() throws BeanProcessingException {

        return new BeanPopulatorImpl();
    }

}
