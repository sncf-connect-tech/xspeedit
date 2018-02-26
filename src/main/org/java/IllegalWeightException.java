package org.java;

/**
 * Exception thrown when an attempt is made to create an product with an uncompliant product weight
 * or when a box
 * @author auzias
 */
public class IllegalWeightException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructs a IllegalWeightException with a specified message.
     * @param msg
     */
    public IllegalWeightException(String msg) {
	super(msg);
    }
}
