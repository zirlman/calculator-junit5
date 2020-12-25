package org.unibl.etf.exceptions;

/**
 * Exception thrown when a number is out of bounds
 *
 * @author Dragan Zrilic
 * @version 1.0.0
 */
public class NumberNotInAreaException extends Exception{

    /**
     * Default constructor.
     */
    public NumberNotInAreaException() {
    }

    /**
     * Constructor from a string.
     *
     * @param message String value that will be incorporated in the message for this exception.
     */
    public NumberNotInAreaException(String message) {
        super(message);
    }
}
