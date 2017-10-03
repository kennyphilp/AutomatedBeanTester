package com.kwp.automatedbeantester.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Kenny on 01/10/2017.
 */
public class StringUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(StringUtils.class);

    public static int numRepeatCharStartStr(String str) {
        int result = 0;

        while (str.substring(0,1).equals(str.substring(result, result+1))) {
            result++;
        }
        return result;
    }

}
