package com.kwp.automatedbeantester.populator;

import com.kwp.automatedbeantester.beaninfo.*;
import com.kwp.automatedbeantester.values.ValueGenerator;
import com.kwp.automatedbeantester.values.ValueGeneratorFactory;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Kenny on 01/10/2017.
 */
public class BeanPopulationFactoryTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(BeanPopulationFactoryTest.class);


    @Test
    public void testBeanpropertiesFactory() throws BeanProcessingException {

        BeanInformation beanInformation = null;
        try {
            beanInformation = BeanInformationFactory.getInstance(TestBeanClass.class);
        } catch (BeanProcessingException e) {
            e.printStackTrace();
        }

        ValueGenerator valueGenerator= ValueGeneratorFactory.getValueGenerator(beanInformation);
        Map<String,Object> beanValues = valueGenerator.generateBeanValues(beanInformation);
        beanValues.entrySet().stream().forEach(e->LOGGER.debug("Key:"+e.getKey()+", Value:"+e.getValue()));

        BeanPopulator beanPopulator= BeanPopulationFactory.generateBeanPopulator();
        Object populatrBean=beanPopulator.generatePopulatedBean(TestBeanClass.class, beanValues);
        assertNotNull(populatrBean);
        assertEquals("com.kwp.automatedbeantester.beaninfo.TestBeanClass",populatrBean.getClass().getName());

        LOGGER.info("Populatrd value is "+(TestBeanClass)populatrBean);

    }


    @Test
    public void testBeanPropertiesAllTypes() throws BeanProcessingException {

        BeanInformation beanInformation = null;
        try {
            beanInformation = BeanInformationFactory.getInstance(TestRandomPropertyGeneratorClass.class);
        } catch (BeanProcessingException e) {
            e.printStackTrace();
        }

        ValueGenerator valueGenerator= ValueGeneratorFactory.getValueGenerator(beanInformation);
        Map<String,Object> beanValues = valueGenerator.generateBeanValues(beanInformation);
        beanValues.entrySet().stream().forEach(e->LOGGER.debug("Key:"+e.getKey()+", Value:"+e.getValue()));

        BeanPopulator beanPopulator= BeanPopulationFactory.generateBeanPopulator();
        TestRandomPropertyGeneratorClass populatedBean=(TestRandomPropertyGeneratorClass)beanPopulator.generatePopulatedBean(TestRandomPropertyGeneratorClass.class,beanValues);

        assertNotNull(populatedBean);
        assertEquals("com.kwp.automatedbeantester.beaninfo.TestRandomPropertyGeneratorClass",populatedBean.getClass().getName());

        assertNotNull(populatedBean.getStringObject());
        assertNotNull(populatedBean.getStringObjectArray1());

        assertNotNull(populatedBean.getBooleanObject1());
        assertNotNull(populatedBean.getBooleanObjectArray1());
        assertNotNull(populatedBean.getBooleanPrimitiveArray1());
        assertNotNull(populatedBean.isBooleanPrimitive1());

        assertNotNull(populatedBean.getIntegerObject1());
        assertNotNull(populatedBean.getIntegerObjectArray1());
        assertNotNull(populatedBean.getIntegerPrimitive1());
        assertNotNull(populatedBean.getIntegerPrimitiveArray1());

        assertNotNull(populatedBean.getFloatObject1());
        assertNotNull(populatedBean.getFloatObjectArray1());
        assertNotNull(populatedBean.getFloatPrimitive1());
        assertNotNull(populatedBean.getFloatPrimitiveArray1());

        assertNotNull(populatedBean.getDoubleObject1());
        assertNotNull(populatedBean.getDoubleObjectArray1());
        assertNotNull(populatedBean.getDoublePrimitive1());
        assertNotNull(populatedBean.getDoublePrimitiveArray1());

        assertNotNull(populatedBean.getCharPrimitive());
        assertNotNull(populatedBean.getCharPrimitiveArray());
        assertNotNull(populatedBean.getCharObject());
        assertNotNull(populatedBean.getCharObjectArray());

        assertNotNull(populatedBean.getBytePrimitive1());
        assertNotNull(populatedBean.getBytePrimitiveArray1());
        assertNotNull(populatedBean.getByteObject1());
        assertNotNull(populatedBean.getByteObjectArray1());

        LOGGER.info("Populatrd value is "+(TestRandomPropertyGeneratorClass)populatedBean);
    }


}
