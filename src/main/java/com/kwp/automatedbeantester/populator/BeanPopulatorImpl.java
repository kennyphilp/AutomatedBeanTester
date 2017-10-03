package com.kwp.automatedbeantester.populator;

import com.kwp.automatedbeantester.beaninfo.BeanInformation;
import com.kwp.automatedbeantester.beaninfo.BeanInformationFactory;
import com.kwp.automatedbeantester.beaninfo.BeanProcessingException;
import com.kwp.automatedbeantester.values.ValueGenerator;
import com.kwp.automatedbeantester.values.ValueGeneratorFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * Created by Kenny on 01/10/2017.
 */
public class BeanPopulatorImpl implements BeanPopulator {

    private static final Logger LOGGER = LoggerFactory.getLogger(BeanPopulatorImpl.class);

    protected BeanPopulatorImpl() {
    }

    @Override
    public final Object generatePopulatedBean(Class objClass, Map<String,Object> beanValues) throws BeanProcessingException {

        Object populatedBeanObject=null;

        try {
            Class<?> c = Class.forName(objClass.getName());
            Constructor<?> cons = c.getConstructor();
            populatedBeanObject = cons.newInstance();
        } catch (NoSuchMethodException|ClassNotFoundException|InstantiationException|IllegalAccessException|InvocationTargetException e) {
            LOGGER.error(e.toString());
            throw new BeanProcessingException(e);
        }

        BeanInformation beanInformation = null;
        try {
            beanInformation = BeanInformationFactory.getInstance(objClass);
        } catch (BeanProcessingException e) {
            LOGGER.error(e.toString());
            throw new BeanProcessingException(e);
        }

        /*
        ValueGenerator valueGenerator= ValueGeneratorFactory.getValueGenerator(beanInformation);
        Map<String,Object> beanValues = valueGenerator.generateBeanValues(beanInformation);
        beanValues.entrySet().stream().forEach(e->LOGGER.debug("Key:"+e.getKey()+", Value:"+e.getValue()));
        */

        Map<String, Method> writeMethods = beanInformation.getWriteMethods();

        for (Map.Entry<String, Method> entry : writeMethods.entrySet()) {

            String methodName=entry.getKey();
            Method method=entry.getValue();

            Object value=beanValues.get(methodName);

            //LOGGER.info("Setting methodName:"+methodName+", Value:"+value+", ValueType:"+value.getClass().getTypeName());
            LOGGER.info("Setting methodName:"+methodName+", Value:"+value);
            try {
                method.invoke(populatedBeanObject,value);
            } catch (IllegalAccessException|InvocationTargetException e) {
                LOGGER.error(e.toString());
            }
        }
        
        
        LOGGER.info("Generating BeanProperties for class:" + beanInformation.getClassName());

        return populatedBeanObject;
    }

}
