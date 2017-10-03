package com.kwp.automatedbeantester.values;

import com.kwp.automatedbeantester.beaninfo.BeanInformation;
import com.kwp.automatedbeantester.beaninfo.BeanInformationImpl;

/**
 * Created by Kenny on 30/09/2017.
 */
public class ValueGeneratorFactory {

    public static ValueGenerator getValueGenerator(BeanInformation beanInfo)
    {
        return new RandomValueGenerator();
    }

}
