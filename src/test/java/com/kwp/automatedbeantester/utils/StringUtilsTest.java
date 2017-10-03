package com.kwp.automatedbeantester.utils;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;

/**
 * Created by Kenny on 01/10/2017.
 */
public class StringUtilsTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(StringUtilsTest.class);

    @Test
    public void testNumRepeatCharStartStr()
    {
        String testStr1="[Ljava.lang.Integer";
        String testStr2="[[Ljava.lang.Integer";
        String testStr3="[[[[[I";

        assertEquals(1, StringUtils.numRepeatCharStartStr(testStr1));
        assertEquals(2,StringUtils.numRepeatCharStartStr(testStr2));
        assertEquals(5,StringUtils.numRepeatCharStartStr(testStr3));
    }

}