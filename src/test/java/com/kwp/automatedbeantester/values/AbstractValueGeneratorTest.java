package com.kwp.automatedbeantester.values;

import com.kwp.automatedbeantester.beaninfo.*;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Kenny on 30/09/2017.
 */
public class AbstractValueGeneratorTest extends AbstractValueGenerator {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractValueGeneratorTest.class);


    @Test
    public void testGenerateBeanProperties() throws BeanProcessingException {

        BeanInformation beanInformation = null;
        try {
            beanInformation = BeanInformationFactory.getInstance(TestRandomPropertyGeneratorClass.class);
        } catch (BeanProcessingException e) {
            e.printStackTrace();
        }
        Map<String, Object> results = this.generateBeanValues(beanInformation);
        assertNotNull(results);
        assertEquals(12, results.size());

        results.entrySet().stream().forEach((p) -> assertNotNull(p.getValue()));
        results.entrySet().stream().forEach((p) -> LOGGER.info(p.getKey() + "," + p.getValue()));

    }

    @Override
    public Object generateIntObj(int arrayDimensions) throws BeanProcessingException {
        return 1;
    }

    @Override
    public Object generateIntPrim(int arrayDimensions) throws BeanProcessingException {
        return null;
    }

    @Override
    public Object generateFloatObj(int arrayDimensions) {
        return 1.0f;
    }

    @Override
    public Object generateFloatPrim(int arrayDimensions) throws BeanProcessingException {
        return null;
    }

    @Override
    public Object generateDoubleObj(int arrayDimensions) {
        return 1.0;
    }

    @Override
    public Object generateDoublePrim(int arrayDimensions) throws BeanProcessingException {
        return null;
    }

    @Override
    public Object generateBooleanObj(int arrayDimensions) throws BeanProcessingException {
        return 1;
    }

    @Override
    public Object generateBooleanPrim(int arrayDimensions) throws BeanProcessingException {
        return null;
    }

    @Override
    public Object generateLongObj(int arrayDimensions) {
        return 1;
    }

    @Override
    public Object generateBytePrim(int arrayDimensions) {
        return null;
    }

    @Override
    public Object generateByteObj(int arrayDimensions) {
        return null;
    }


    @Override
    public String generateString(int arrayDimensions, int size) {
        return "";
    }

    @Override
    public String generateString(int arrayDimensions) {
        return "";
    }

    @Override
    public Object generateCharObj(int arrayDimensions) {
        return null;
    }

    @Override
    public Object generateCharPrim(int arrayDimensions) throws BeanProcessingException {
        return null;
    }


}
