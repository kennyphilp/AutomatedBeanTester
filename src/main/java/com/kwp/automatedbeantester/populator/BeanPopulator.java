package com.kwp.automatedbeantester.populator;

import com.kwp.automatedbeantester.beaninfo.BeanProcessingException;

import java.util.Map;

/**
 * Created by Kenny on 01/10/2017.
 */
public interface BeanPopulator {

    public Object generatePopulatedBean(Class objClass, Map<String,Object> beanValues) throws BeanProcessingException;

}
