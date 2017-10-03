package com.kwp.automatedbeantester.validator;

import com.kwp.automatedbeantester.beaninfo.BeanInformation;
import com.kwp.automatedbeantester.beaninfo.BeanInformationFactory;
import com.kwp.automatedbeantester.beaninfo.BeanProcessingException;
import com.kwp.automatedbeantester.beaninfo.TestRandomPropertyGeneratorClass;
import com.kwp.automatedbeantester.validtor.BeanValidator;
import com.kwp.automatedbeantester.validtor.BeanValidatorFactory;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Kenny on 01/10/2017.
 */
public class BeanValidatorFactoryTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(BeanValidatorFactoryTest.class);
    
    @Test
    public void testBeanpropertiesFactory() throws BeanProcessingException {

        BeanValidator validator = BeanValidatorFactory.getValidator();
        BeanInformation beanInformation = null;
        try {
            beanInformation = BeanInformationFactory.getInstance(TestRandomPropertyGeneratorClass.class);

        } catch (BeanProcessingException e) {
            e.printStackTrace();
        }

        assertFalse(validator.validate(beanInformation));
    }

}
