package com.kwp.automatedbeantester.values;

import com.kwp.automatedbeantester.beaninfo.*;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Kenny on 01/10/2017.
 */
public class ValueGeneratorTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ValueGeneratorTest.class);


    @Test
    public void testBeanpropertiesFactory() throws BeanProcessingException {

        BeanInformation beanInformation = null;
        try {
            beanInformation = BeanInformationFactory.getInstance(TestRandomPropertyGeneratorClass.class);
        } catch (BeanProcessingException e) {
            e.printStackTrace();
        }

        ValueGenerator valGen = ValueGeneratorFactory.getValueGenerator(beanInformation);

        Object valObj=valGen.generateBooleanObj(0);
        assertNotNull(valObj);
        assertEquals("java.lang.Boolean",valObj.getClass().getTypeName());

        Object valObjArray=valGen.generateBooleanObj(1);
        assertNotNull(valObjArray);
        assertEquals("java.lang.Boolean[]",valObjArray.getClass().getTypeName());
    }

}
