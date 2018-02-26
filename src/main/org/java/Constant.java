package org.java;

public interface Constant {
    static int MINIMAL_WEIGHT = 1;
    static int PRODUCT_MAXIMAL_WEIGHT = 9;
    static int BOX_MAXIMAL_WEIGHT = 10;
    static String EXCEPTION_MESSAGE_BASE = "Weight is too ";
    static String EXCEPTION_MESSAGE_UNIT = " unit).";
    static String EXCEPTION_MESSAGE_HEAVY = EXCEPTION_MESSAGE_BASE + "heavy (";
    static String EXCEPTION_MESSAGE_LIGHT = EXCEPTION_MESSAGE_BASE + "light (";
}
