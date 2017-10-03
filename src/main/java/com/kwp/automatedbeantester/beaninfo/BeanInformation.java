package com.kwp.automatedbeantester.beaninfo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

/**
 * Created by Kenny on 01/10/2017.
 */
public interface BeanInformation {
    String getClassName();

    public Class getBeanClass();

    public List<String> getProperyNames();

    public Map<String, Method> getWriteMethods();

    public Map<String, Method> getReadMethods();

    public Map<String, Field> getFields();

    @Override
    String toString();
}
