package com.ouisncf.packaging.util;

/**
 * Utility class used to declare shared properties
 *
 * @author Seiffeddine BALLOUM
 */
public class CommonUtil {
    public static final String NO_NUMERIC_INPUT = "The items size input contains no-numeric data";
    public static final String INPUT_MISSING = "items size input is missing";

    private CommonUtil(){
        throw new IllegalStateException("Utility class");
    }
}
