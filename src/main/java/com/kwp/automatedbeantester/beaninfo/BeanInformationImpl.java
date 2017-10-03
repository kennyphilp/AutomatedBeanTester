package com.kwp.automatedbeantester.beaninfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

/**
 * Created by Kenny on 30/09/2017.
 */
public class BeanInformationImpl implements BeanInformation {

    private static final Logger LOGGER = LoggerFactory.getLogger(BeanInformationImpl.class);

    private Class beanClass;
    private BeanInfo beanInfo;
    private Map<String,Field> fieldMap;

    protected BeanInformationImpl(Class beanClass) throws BeanProcessingException {
        this.beanClass = beanClass;

        try {
            beanInfo = Introspector.getBeanInfo(beanClass);
        } catch (IntrospectionException e) {
            LOGGER.info("IntrospectionException error processing class {}, {} ", beanClass.getName(), e.toString());
            throw new BeanProcessingException("Failed to create new BeanInformationImpl object for class " + beanClass.getName());
        }

        fieldMap = Arrays.stream(this.beanClass.getDeclaredFields())
                .filter(field -> !field.getName().startsWith("this"))
                .collect(Collectors.toMap(field -> field.getName(), field -> field));
    }

    @Override
    public String getClassName()
    {
        return beanClass.getName();
    }

    @Override
    public Class getBeanClass()
    {
        return beanClass;
    }

    @Override
    public List<String> getProperyNames()
    {
        return Arrays.stream(beanInfo.getPropertyDescriptors())
                .map(p->p.getName())
                .filter(p->!p.endsWith("class"))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public Map<String, Method> getWriteMethods() {
        return Arrays.stream(beanInfo.getPropertyDescriptors())
                .filter(p->!p.getName().endsWith("class")).collect(
                Collectors.toMap(
                        p -> p.getName(), p -> p.getWriteMethod()
                ));
    }

    @Override
    public Map<String, Method> getReadMethods() {
        return Arrays.stream(beanInfo.getPropertyDescriptors())
                .filter(p->!p.getName().endsWith("class"))
                .collect(
                Collectors.toMap(
                        p -> p.getName(), p -> p.getReadMethod()
                ));
    }

    @Override
    public Map<String, Field> getFields() {
        return fieldMap;
    }


    @Override
    public String toString() {
        return "BeanInformationImpl{" +
                "beanClass=" + beanClass +
                ", beanInfo=" + beanInfo +
                '}';
    }
}
