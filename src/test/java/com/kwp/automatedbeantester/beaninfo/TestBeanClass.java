package com.kwp.automatedbeantester.beaninfo;

/**
 * Created by Kenny on 30/09/2017.
 */
public class TestBeanClass {
    private Boolean booleanObject1;
    private boolean booleanPrimitive1;

    public Boolean getBooleanObject1() {
        return booleanObject1;
    }

    public void setBooleanObject1(Boolean booleanObject1) {
        this.booleanObject1 = booleanObject1;
    }

    public boolean isBooleanPrimitive1() {
        return booleanPrimitive1;
    }

    public void setBooleanPrimitive1(boolean booleanPrimitive1) {
        this.booleanPrimitive1 = booleanPrimitive1;
    }

    @Override
    public String toString() {
        return "TestBeanClass{" +
                "booleanObject1=" + booleanObject1 +
                ", booleanPrimitive1=" + booleanPrimitive1 +
                '}';
    }
};
