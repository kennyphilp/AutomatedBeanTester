package com.kwp.automatedbeantester.validtor;

import com.kwp.automatedbeantester.beaninfo.BeanInformation;
import com.kwp.automatedbeantester.beaninfo.BeanProcessingException;
import com.kwp.automatedbeantester.populator.BeanPopulationFactory;
import com.kwp.automatedbeantester.populator.BeanPopulator;
import com.kwp.automatedbeantester.values.ValueGenerator;
import com.kwp.automatedbeantester.values.ValueGeneratorFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Created by Kenny on 02/10/2017.
 */
public class BeanValidatorImpl implements BeanValidator {

    private static final Logger LOGGER = LoggerFactory.getLogger(BeanValidatorImpl.class);


    protected BeanValidatorImpl() {
    }

    @Override
    public boolean validate(BeanInformation beanInfo) throws BeanProcessingException {
        boolean result=false;

        ValueGenerator valueGenerator= ValueGeneratorFactory.getValueGenerator(beanInfo);
        Map<String,Object> beanValues = valueGenerator.generateBeanValues(beanInfo);
        beanValues.entrySet().stream().forEach(e->LOGGER.debug("Key:"+e.getKey()+", Value:"+e.getValue()));

        BeanPopulator beanPopulator= BeanPopulationFactory.generateBeanPopulator();

        Object populatedBean=beanPopulator.generatePopulatedBean(beanInfo.getBeanClass(),beanValues);
        LOGGER.info("PopulatedBean:"+populatedBean);

        

        return result;
    }

}
