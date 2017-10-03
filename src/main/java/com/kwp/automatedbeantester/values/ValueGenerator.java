package com.kwp.automatedbeantester.values;

import com.kwp.automatedbeantester.beaninfo.BeanInformation;
import com.kwp.automatedbeantester.beaninfo.BeanInformationImpl;
import com.kwp.automatedbeantester.beaninfo.BeanProcessingException;

import java.util.Map;

/**
 * Created by Kenny on 30/09/2017.
 */
public interface ValueGenerator {

    public Map<String,Object> generateBeanValues(BeanInformation beanInfo) throws BeanProcessingException;

    public Object generateIntObj(int arrayDimensions) throws BeanProcessingException;

    public Object generateIntPrim(int arrayDimensions) throws BeanProcessingException;

    public Object generateFloatObj(int arrayDimensions) throws BeanProcessingException;

    public Object generateFloatPrim(int arrayDimensions) throws BeanProcessingException;

    public Object generateDoubleObj(int arrayDimensions) throws BeanProcessingException;

    public Object generateDoublePrim(int arrayDimensions) throws BeanProcessingException;

    public Object generateBooleanObj(int arrayDimensions) throws BeanProcessingException;

    public Object generateBooleanPrim(int arrayDimensions) throws BeanProcessingException;

    public Object generateLongObj(int arrayDimensions) throws BeanProcessingException;

    public Object generateBytePrim(int arrayDimensions) throws BeanProcessingException;

    public Object generateByteObj(int arrayDimensions) throws BeanProcessingException;

    public Object generateString(int arrayDimensions, int size) throws BeanProcessingException;

    public Object generateString(int arrayDimensions) throws BeanProcessingException;

    public Object generateCharObj(int arrayDimensions) throws BeanProcessingException;

    public Object generateCharPrim(int arrayDimensions) throws BeanProcessingException;
}
